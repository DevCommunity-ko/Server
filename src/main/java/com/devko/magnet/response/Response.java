package com.devko.magnet.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Response<T> {

	private int code;
	private String message;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;

	public Response withCodeAndMessage(int code, String message) {
		this.code = code;
		this.message = message;
		return this;
	}

	public Response<T> withAll(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
		return this;
	}
}
