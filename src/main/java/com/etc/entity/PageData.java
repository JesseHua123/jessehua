package com.etc.entity;

import java.util.List;

/**
 * 分页实体类
 */
public class PageData {
	
	private List DATA;//查询数据库的数据
	private Integer PAGENO; //当前页
	private Integer PAGESIZE;//每页显示记录数
	private Integer TOTALCOUNT;//总记录数
	private Integer TOTALPAGE;//总页数

	public List getDATA() {
		return DATA;
	}
	public void setDATA(List dATA) {
		DATA = dATA;
	}
	public Integer getPAGENO() {
		return PAGENO;
	}
	public void setPAGENO(Integer pAGENO) {
		PAGENO = pAGENO;
	}
	public Integer getPAGESIZE() {
		return PAGESIZE;
	}
	public void setPAGESIZE(Integer pAGESIZE) {
		PAGESIZE = pAGESIZE;
	}
	public Integer getTOTALCOUNT() {
		return TOTALCOUNT;
	}
	public void setTOTALCOUNT(Integer tOTALCOUNT) {
		TOTALCOUNT = tOTALCOUNT;
	}
	public Integer getTOTALPAGE() {
		return TOTALPAGE;
	}
	public void setTOTALPAGE(Integer tOTALPAGE) {
		TOTALPAGE = tOTALPAGE;
	}
	
	public PageData(List dATA, Integer pAGENO, Integer pAGESIZE, Integer tOTALCOUNT) {
		super();
		DATA = dATA;
		PAGENO = pAGENO;
		PAGESIZE = pAGESIZE;
		TOTALCOUNT = tOTALCOUNT;
		TOTALPAGE = TOTALCOUNT%PAGESIZE == 0 ? TOTALCOUNT/PAGESIZE : (TOTALCOUNT/PAGESIZE+1);
	}

	
}


