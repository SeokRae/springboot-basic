package com.example.kdtspringorder4.exception;

import java.text.MessageFormat;

public class PercentOverException extends RuntimeException {
	public PercentOverException(String message, long percent) {
		super(MessageFormat.format(message, percent));
	}
}
