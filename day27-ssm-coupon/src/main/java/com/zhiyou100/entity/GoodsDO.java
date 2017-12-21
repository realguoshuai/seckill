package com.zhiyou100.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class GoodsDO implements Serializable {

	private static final long serialVersionUID = -8204697602942835785L;

	private Integer id;
	
	private String name;
	
	private String info;
	
	private String image;
	
	private Integer count;
	
	private Integer price;
	
	private Date beginTime;
	
	private Date endTime;

	// 一种商品对应多条领取记录
	private List<UserGoodsDO> userGoods;
	
	@Override
	public String toString() {
		return "GoodsDO [id=" + id + ", name=" + name + ", info=" + info + ", image=" + image + ", count=" + count
				+ ", price=" + price + ", beginTime=" + beginTime + ", endTime=" + endTime + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public List<UserGoodsDO> getUserGoods() {
		return userGoods;
	}

	public void setUserGoods(List<UserGoodsDO> userGoods) {
		this.userGoods = userGoods;
	}
}
