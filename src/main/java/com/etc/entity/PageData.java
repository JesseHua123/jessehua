package com.etc.entity;

import java.util.List;

/**
 * ��ҳʵ����
 */
public class PageData {
	
	private List DATA;//��ѯ���ݿ������
	private Integer PAGENO; //��ǰҳ
	private Integer PAGESIZE;//ÿҳ��ʾ��¼��
	private Integer TOTALCOUNT;//�ܼ�¼��
	private Integer TOTALPAGE;//��ҳ��

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


