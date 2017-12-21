package com.zhiyou100.vo;

public class GoodsListQueryVO {

	// 页码
	private Integer pageIndex;

	// 关键字
	private String keyword;

	// true 降序 false 升序 null 没有选择
	private Boolean count;
	
	
	//----------------- 上边是请求参数的封装，下边是数据库查询参数的封装
	// pageIndex 和 keyword 需要转换后才能在数据库查询的时候使用
	// pageIndex ===> index，数据索引
	// keyword ===> keywords，关键字数组
	
	
	// 数据库查询的关键字数组
	private String[] keywords;
	
	// 数据库查询的起始索引
	private int index;

	@Override
	public String toString() {
		return "GoodsListQueryVO [pageIndex=" + pageIndex + ", keyword=" + keyword + ", count=" + count + "]";
	}

	public Integer getPageIndex() {

		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Boolean getCount() {
		return count;
	}

	public void setCount(Boolean count) {
		this.count = count;
	}

	public String[] getKeywords() {

		if (keyword == null) {

			// 没有关键字，就没有关键字数组
			return null;
		}else {

			// 有关键字，才有关键字数组
			return keyword.split(" ");
		}
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public int getIndex() {

		if (pageIndex == null) {
			
			return 0;
		}else {
			
			return (pageIndex - 1) * 5;
		}
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
