/**
 * 
 */
package com.susheelkb.romannumeral.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;
import com.susheelkb.romannumeral.domain.RomanNumber;
import com.susheelkb.romannumeral.exception.NumberIsZeroException;
import com.susheelkb.romannumeral.exception.RangeQueryException;
import com.susheelkb.romannumeral.exception.RangeViolationException;
import com.susheelkb.romannumeral.util.AppConstants;

/**
 *
 * 
 * @author : Susheel Kaparaboyna
 *
 */
@Service
public class RomanNumeralConverterService {

	/**
	 * Returns the Roman numeral equivalent of the given number.
	 * 
	 * @param numberToConvert
	 * @return Roman Numeral
	 */

	// This can be read from configuration file and changed as per the instance
	// the code is running uopon
	private ExecutorService calculatorExecutorService = Executors.newFixedThreadPool(20);

	/**
	 * 
	 * @param numberToConvert
	 * @return
	 */
	public RomanNumber toRomanNumber(Integer numberToConvert) {
		checkSupportedRange(numberToConvert);
		RomanNumber romanNumber = new RomanNumber();
		romanNumber.setInput(numberToConvert);
		StringBuilder result = new StringBuilder();
		for (Entry<Integer, String> entry : AppConstants.CORRESPONDING_ROMAN.entrySet()) {
			while (entry.getKey() <= numberToConvert) {
				result.append(entry.getValue());
				numberToConvert -= entry.getKey();
			}
		}
		romanNumber.setOutput(result.toString());
		return romanNumber;
	}

	/**
	 * 
	 * @param numberToConvert
	 * @return
	 */
	// Async Processing
	private Future<RomanNumber> aysncToRomanNumber(Integer numberToConvert) {
		return calculatorExecutorService.submit(() -> toRomanNumber(numberToConvert));
	}

	/**
	 * 
	 * @param numberToConvert
	 */
	private void checkSupportedRange(int numberToConvert) {
		if (numberToConvert == 0) {
			throw new NumberIsZeroException(
					"Query parameter value is 0," + " roman numbers do not have a 0. Smallest supported value is 1.");
		}
		if (numberToConvert < AppConstants.MIN_NUMBER_TO_CONVERT
				|| numberToConvert > AppConstants.MAX_NUMBER_TO_CONVERT) {
			throw new RangeViolationException("The number entered must be between " + AppConstants.MIN_NUMBER_TO_CONVERT
					+ "and " + AppConstants.MAX_NUMBER_TO_CONVERT);
		}
	}

	/**
	 * 
	 * @param minNumber
	 * @param maxNumber
	 * @return
	 */
	public List<RomanNumber> convertRangeToRoman(int minNumber, int maxNumber) {
		Map<Integer, Future> numberToFutureMap = new HashMap<>();
		checkSupportedRange(minNumber);
		checkSupportedRange(maxNumber);
		if (maxNumber < minNumber) {
			throw new RangeQueryException("Min should always be less than or equal to Max");
		}
		List<RomanNumber> multiResultList = new ArrayList<RomanNumber>();
		for (int number = minNumber; number <= maxNumber; number++) {
			numberToFutureMap.put(number, aysncToRomanNumber(number));
		}
		numberToFutureMap.forEach((key, val) -> {
			try {
				multiResultList.add((RomanNumber) val.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
		return multiResultList;
	}

}
