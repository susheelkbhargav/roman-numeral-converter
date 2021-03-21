/**
 * 
 */
package com.susheelkb.romannumeral.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.springframework.stereotype.Service;
import com.susheelkb.romannumeral.domain.RomanNumber;
import com.susheelkb.romannumeral.exception.NumberIsZeroException;
import com.susheelkb.romannumeral.exception.RangeViolationException;
import com.susheelkb.romannumeral.util.RomanNumsAppConstants;

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

	public RomanNumber toRomanNumber(Integer numberToConvert) {
		if (numberToConvert == 0) {
			throw new NumberIsZeroException(
					"Query parameter value is 0," + " roman numbers do not have a 0. Smallest supported value is 1.");
		}
		if (numberToConvert < RomanNumsAppConstants.MIN_NUMBER_TO_CONVERT || numberToConvert > RomanNumsAppConstants.MAX_NUMBER_TO_CONVERT) {
			throw new RangeViolationException(
					"The number entered must be between " + RomanNumsAppConstants.MIN_NUMBER_TO_CONVERT + "and " + RomanNumsAppConstants.MAX_NUMBER_TO_CONVERT);
		}
		RomanNumber romanNumber = new RomanNumber();
		romanNumber.setInput(numberToConvert);
		StringBuilder result = new StringBuilder();
		for (Entry<Integer, String> entry : RomanNumsAppConstants.CORRESPONDING_ROMAN.entrySet()) {
			while (entry.getKey() <= numberToConvert) {
				result.append(entry.getValue());
				numberToConvert -= entry.getKey();
			}
		}
		romanNumber.setOutput(result.toString());
		return romanNumber;

	}

	public List<RomanNumber> convertRangeToRoman(int minNumber, int maxNumber) {
		List<RomanNumber> romanNumList = new ArrayList<>();
		RomanNumber romanNumber1 = toRomanNumber(minNumber);
		RomanNumber romanNumber2 = toRomanNumber(maxNumber);
		romanNumList.add(romanNumber1);
		romanNumList.add(romanNumber2);
		return romanNumList;
	}
}
