package com.zhiyou100.dto;

import java.util.List;

import com.zhiyou100.entity.GoodsDO;

public class GoodsListDTO {

	private List<GoodsDO> list;
	
	private int pageCount;
	
	private int pageIndex;


	@Override
	public String toString() {
		return "GoodsListDTO [list=" + list + ", pageCount=" + pageCount + ", pageIndex=" + pageIndex + "]";
	}

	public List<GoodsDO> getList() {
		return list;
	}

	public void setList(List<GoodsDO> list) {
		this.list = list;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
