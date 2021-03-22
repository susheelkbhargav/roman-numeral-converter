/**
 * 
 */
package com.susheelkb.romannumeral.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.susheelkb.romannumeral.domain.RomanNumeralList;
import com.susheelkb.romannumeral.domain.RomanNumber;
import com.susheelkb.romannumeral.service.RomanNumeralConverterService;

import java.util.List;

import org.slf4j.Logger;

/**
 * 
 * @author susheel.kaparaboyna
 *
 */
@RestController
public class RomanNumeralConverterController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RomanNumeralConverterService romanNumeralConverterService;

	/**
	 * 
	 * @param number
	 * @return
	 */

	@GetMapping(value = "/romannumeral", params = { "query" })
	public ResponseEntity<RomanNumber> toRomanNum(@RequestParam("query") String param){
		int number = Integer.parseInt(param);
		RomanNumber romanNumber = romanNumeralConverterService.toRomanNumber(number);
		logger.info("/romannumeral called with " + number);
		return ResponseEntity.ok(romanNumber);
	}

	/**
	 * 
	 * @param minNumber
	 * @param maxNumber
	 * @return
	 */
	@GetMapping(value = "/romannumeral", params = { "min", "max" })
	public ResponseEntity<RomanNumeralList> convertRangeToRomanNumeral(@RequestParam("min") int minNumber,
			@RequestParam("max") int maxNumber) {
		List<RomanNumber> romanNumberList = romanNumeralConverterService.convertRangeToRoman(minNumber, maxNumber);
		RomanNumeralList conversion= new RomanNumeralList(romanNumberList);
		logger.info("/romannumeral called with range " +minNumber+ " "+ maxNumber);
		return ResponseEntity.ok(conversion);
	}
}
