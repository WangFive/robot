package com.wang.robot.bean;

import java.io.Serializable;

/**********************************************************
 * All Rights Reserved.
 * 文件名称： Result.java
 * 摘 要：
 * 初始版本：1.0.0
 * 原 作 者：wangch
 * 完成日期： 2018/4/4
 * 当前版本： 1.0.0
 * 作 者： wangch
 * 完成日期： 2018/4/4
 *****************************************************************/
public class Result<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1454942575567729092L;
	/**
	 * 
	 */
	public static final int SUCCESS = 1;
	/**
	 * 
	 */
	public static final int FAIL = 0;
	/**
	 * 
	 */
	public static final int NO_PERMISSION = 2;
	/**
	 * 结果状态说明
	 */
	private String msg = "success";
	/**
	 * 结果状态代码
	 */
	private int code = SUCCESS;
	/**
	 * 结果
	 */
	private T data;

	public Result() {
		super();
	}

	public Result(T data) {
		super();
		this.data = data;
	}

	public Result(Throwable e) {
		super();
		this.msg = e.toString();
		this.code = FAIL;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * 操作失败,设置结果状态为失败
	 */
	public void fail() {
		this.code = FAIL;
	}
	
	/**
	 * 操作成功,设置结果状态为成功
	 */
	public void success() {
		this.code = SUCCESS;
	}
	
	/**
	 * 是否成功
	 * 
	 * @return
	 */
	public boolean isSuccessed() {
		return this.code == SUCCESS;
	}
	
	/**
	 * 是否失败
	 * 
	 * @return
	 */
	public boolean isFailed() {
		return this.code == FAIL;
	}
}