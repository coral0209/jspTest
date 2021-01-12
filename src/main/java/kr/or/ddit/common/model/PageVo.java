package kr.or.ddit.common.model;

public class PageVo {
	
	private int page; 
	private int pagesize; 
	

	public PageVo() {}
	public PageVo(int page, int pasesize) {
		super();
		this.page = page;
		this.pagesize = pasesize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPasesize() {
		return pagesize;
	}
	public void setPagesize(int pasesize) {
		this.pagesize = pasesize;
	}
	@Override
	public String toString() {
		return "PageVo [page=" + page + ", paseSize=" + pagesize + "]";
	}
	
}
