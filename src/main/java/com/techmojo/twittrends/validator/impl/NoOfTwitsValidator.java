package com.techmojo.twittrends.validator.impl;

import com.techmojo.twittrends.exception.NoOfTwitsValidatorException;
import com.techmojo.twittrends.matcher.impl.NumberMatcher;
import com.techmojo.twittrends.util.AppConstants;
import com.techmojo.twittrends.validator.Validator;

public class NoOfTwitsValidator extends Validator<String> {

	public NoOfTwitsValidator(String noOfTwitsStr) {
		super(noOfTwitsStr);
	}

	@Override
	public void validate() {
		if (new NumberMatcher(data).matches()) {
			throw new NoOfTwitsValidatorException(AppConstants.INVALID_NO_OF_TWITS_INPUT);
		}
		Long noOfTwits = Long.parseLong(data);
		if (noOfTwits <= 0L) {
			throw new NoOfTwitsValidatorException(AppConstants.NO_OF_TWITS_INPUT_LESS_THAN_0);
		}
		super.validate();
	}
}
