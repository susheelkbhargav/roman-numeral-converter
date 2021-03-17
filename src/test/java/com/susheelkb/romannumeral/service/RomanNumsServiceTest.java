/**
 * 
 */
package com.susheelkb.romannumeral.service;

import org.junit.Before;
import com.susheelkb.romannumeral.service.RomanNumeralConverterService;

/**
 * @author susheel.kaparaboyna
 *
 */
public class RomanNumsServiceTest {
	private RomanNumeralConverterService numsService;
	
	@Before
	public  void setUp() {
		numsService = new RomanNumeralConverterService();
	}
}
