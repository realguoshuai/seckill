package com.zhiyou100.service.exception;

// 秒杀操作产生的异常，
// 只有继承 runtimeException 才能触发事务的回滚操作
public class SeckillException extends RuntimeException {

	private static final long serialVersionUID = 3076962008083008443L;

	public SeckillException(String message) {
		super(message);
	}
}
