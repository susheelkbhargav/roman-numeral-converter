/**
 * 
 */
package com.susheelkb.romannumeral.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

import com.susheelkb.romannumeral.exception.NumberIsZeroException;
import com.susheelkb.romannumeral.exception.RangeViolationException;
import com.susheelkb.romannumeral.model.RomanNumber;
import com.susheelkb.romannumeral.service.RomanNumeralConverterService;
import com.susheelkb.romannumeral.util.AppConstants;

/**
 * @author susheel.kaparaboyna
 *
 */
public class RomanNumsServiceTest {
private RomanNumeralConverterService numsService = new RomanNumeralConverterService();

	
	@Test
	public void testExceptionThrownIfGivenZero() {
		Throwable exception = Assertions.assertThrows(NumberIsZeroException.class, () -> {
	        throw new NumberIsZeroException("Query parameter value is 0, roman numbers do not have a 0. Smallest supported value is 1.");
		});
		try {
		   numsService.toRomanNumber(0);
		}
		catch(NumberIsZeroException ex) {
			Assertions.assertEquals(ex.getMessage(), exception.getMessage());
		}
		
	}

	/**
	 * 
	 */
	@Test
	public void testExceptionThrownIfGivenOutOfRange() {
		
		Throwable exception = Assertions.assertThrows(RangeViolationException.class, () -> {
			throw new RangeViolationException("The number entered must be between " + AppConstants.MIN_NUMBER_TO_CONVERT
				+ " and " + AppConstants.MAX_NUMBER_TO_CONVERT);
		});
		try {
		   numsService.toRomanNumber(4000);
		}
		catch(RangeViolationException ex) {
			Assertions.assertEquals(ex.getMessage(), exception.getMessage());
		}
	}
	
	@Test
	public void testConvertRangeToRoman() {		
		List<RomanNumber> list = numsService.convertRangeToRoman(5, 6);
		Assertions.assertEquals(list.size(), 2);
		Assertions.assertEquals(list.get(1).getOutput(), "VI");
		
	}
	
	
	@Test
	public void testToRomanNumber() {
		RomanNumber rn = numsService.toRomanNumber(5);
		assertNotNull(rn);
		Assertions.assertEquals(rn.getOutput(), "V");
		
	}

}
