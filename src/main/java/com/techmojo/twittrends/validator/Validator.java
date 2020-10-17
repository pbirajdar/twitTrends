package com.techmojo.twittrends.validator;

public abstract class Validator<T> {

	private Validator<T> nextValidator;
	protected T data;

	protected Validator(T data) {
		this.nextValidator = null;
		this.data = data;
	}

	public final void nextValidator(Validator<T> validator) {
		this.nextValidator = validator;
	}

	public void validate() {
		if (nextValidator != null)
			nextValidator.validate();
	}
}
