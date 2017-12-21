package com.zhiyou100.entity;

import java.io.Serializable;
import java.util.Date;

public class UserGoodsDO implements Serializable {

	private static final long serialVersionUID = -6841317325539694255L;

	private Integer userId;
	
	private Integer goodsId;
	
	private Integer count;

	private Date time;
	
	// 一条领取记录对应一个用户
	private UserDO user;

	public UserGoodsDO() {
		super();
	}

	public UserGoodsDO(Integer userId, Integer goodsId, Integer count) {
		super();
		this.userId = userId;
		this.goodsId = goodsId;
		this.count = count;
	}



	@Override
	public String toString() {
		return "UserGoodsDO [userId=" + userId + ", goodsId=" + goodsId + ", count=" + count + ", time=" + time + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public UserDO getUser() {
		return user;
	}

	public void setUser(UserDO user) {
		this.user = user;
	}
}
