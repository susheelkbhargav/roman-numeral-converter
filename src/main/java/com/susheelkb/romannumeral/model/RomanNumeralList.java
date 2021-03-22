package com.susheelkb.romannumeral.model;

import java.util.List;

public class RomanNumeralList {
	private List<RomanNumber> conversions;

	public RomanNumeralList(List<RomanNumber> romanNumberList) {
		this.conversions=romanNumberList;
	}

	public List<RomanNumber> getConversions() {
		return conversions;
	}

	public void setConversions(List<RomanNumber> romanNumberList) {
		this.conversions = romanNumberList;
	}
}
