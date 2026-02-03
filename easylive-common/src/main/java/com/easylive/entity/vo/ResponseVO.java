package com.easylive.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: KunSpireUp
 * @Date: 3/27/2024 12:35 AM
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO<T> {

	private String status;

	private Integer code;

	private String info;

	private T data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
