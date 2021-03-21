/**
 * 
 */
package com.susheelkb.romannumeral.service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.susheelkb.romannumeral.domain.RomanNumber;
import com.susheelkb.romannumeral.exception.NumberIsZeroException;
import com.susheelkb.romannumeral.exception.RangeViolationException;
import com.susheelkb.romannumeral.service.RomanNumeralConverterService;

/**
 * @author susheel.kaparaboyna
 *
 */
public class RomanNumsServiceTest {
	private RomanNumeralConverterService numsService;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		numsService = new RomanNumeralConverterService();
	}

	/**
	 * 
	 */
	@Test(expected = NumberIsZeroException.class)
	public void testExceptionThrownIfGivenZero() {
		numsService.toRomanNumber(0);
	}

	/**
	 * 
	 */
	@Test(expected = RangeViolationException.class)
	public void testExceptionThrownIfGivenOutOfRange() {
		numsService.toRomanNumber(4000);
	}

}
