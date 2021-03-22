/**
 * 
 */
package com.susheelkb.romannumeral.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.susheelkb.romannumeral.model.RomanNumber;
import com.susheelkb.romannumeral.model.RomanNumeralList;
import com.susheelkb.romannumeral.service.RomanNumeralConverterService;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;

/**
 * 
 * @author susheel.kaparaboyna
 *
 */
@RestController
@Validated
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
	public ResponseEntity<RomanNumber> toRomanNum(@RequestParam("query")  @Valid @NotEmpty String param){
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
	public ResponseEntity<RomanNumeralList> convertRangeToRomanNumeral(@RequestParam("min")@Valid @NotEmpty String minParam,
			@RequestParam("max") @Valid @NotEmpty String maxParam) {
		int minNumber = Integer.parseInt(minParam);
		int maxNumber = Integer.parseInt(maxParam);
		List<RomanNumber> romanNumberList = romanNumeralConverterService.convertRangeToRoman(minNumber, maxNumber);
		RomanNumeralList conversion= new RomanNumeralList(romanNumberList);
		logger.info("/romannumeral called with range " +minNumber+ " "+ maxNumber);
		return ResponseEntity.ok(conversion);
	}
}
