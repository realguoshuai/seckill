package com.zhiyou100.service.exception;

public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 2809314205218734781L;

	public LoginException(String message) {
		super(message);
	}
}
