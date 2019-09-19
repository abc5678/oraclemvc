package com.spring.domain;

public class MakePage {
	private int currPage;
	private int totalCount;
	private int pageSize;
	private int blockSize;
	private int startRow;
	private int endRow;
	private int startBlock;
	private int endBlock;
	private boolean next;
	private boolean prev;
	
	public MakePage(int currPage, int totalCount, int pageSize, int blockSize) {
		this.currPage = currPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		calDate();
	}
	
	private void calDate() {
		startRow=(currPage-1)*pageSize+1;
		endRow=startRow+pageSize-1;
		if(endRow>totalCount) {
			endRow=totalCount;
		}
		startBlock=(((currPage-1)/blockSize)*blockSize)+1;
		endBlock=startBlock+blockSize-1;
		//int totalPage=(int)Math.ceil(totalCount/(double)pageSize);
		int totalPage=(totalCount-1)/pageSize+1;
		if(endBlock>totalPage) {
			endBlock=totalPage;
		}
		prev=(startBlock==1)? false:true;
		next=(endBlock>totalPage)? true:false;
	}

	public int getStartRow() {
		return startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public int getStartBlock() {
		return startBlock;
	}
	public int getEndBlock() {
		return endBlock;
	}
	public boolean isNext() {
		return next;
	}
	public boolean isPrev() {
		return prev;
	}

	public int getCurrPage() {
		return currPage;
	}

}
