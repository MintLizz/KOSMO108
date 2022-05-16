package a.b.c.com.kosmo.product.vo;

import org.apache.log4j.Logger;

public class KosmoProductVO {
	
	private static Logger logger = Logger.getLogger(KosmoProductVO.class);

	
	private String kpnum;
	private String kpid;
	private String kpcnt;
	private String kpprice;
	private String kpdesc;
	private String kpcompany;
	private String kpimage;
	private String kpname;
	private String kpdeleteyn;
	private String kpinsertdate;
	private String kpupdatedate;
	
	// 페이징 이동 필드
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;
	


	public KosmoProductVO() {
		
	}



	public KosmoProductVO(String kpnum, String kpid, String kpcnt, String kpprice, String kpdesc, String kpcompany,
			String kpimage, String kpname, String kpdeleteyn, String kpinsertdate, String kpupdatedate) {
		
		this.kpnum = kpnum;
		this.kpid = kpid;
		this.kpcnt = kpcnt;
		this.kpprice = kpprice;
		this.kpdesc = kpdesc;
		this.kpcompany = kpcompany;
		this.kpimage = kpimage;
		this.kpname = kpname;
		this.kpdeleteyn = kpdeleteyn;
		this.kpinsertdate = kpinsertdate;
		this.kpupdatedate = kpupdatedate;
	}

	
	
	public KosmoProductVO(	String kpnum, String kpid, String kpcnt, String kpprice, String kpdesc, 
							String kpcompany, String kpimage, String kpname, String kpdeleteyn, String kpinsertdate,
							String kpupdatedate, String pageSize,String groupSize, String curPage, String totalCount) {

		this.kpnum = kpnum;
		this.kpid = kpid;
		this.kpcnt = kpcnt;
		this.kpprice = kpprice;
		this.kpdesc = kpdesc;
		this.kpcompany = kpcompany;
		this.kpimage = kpimage;
		this.kpname = kpname;
		this.kpdeleteyn = kpdeleteyn;
		this.kpinsertdate = kpinsertdate;
		this.kpupdatedate = kpupdatedate;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}



	// getter 
	public String getKpnum() {
		return kpnum;
	}



	public String getKpid() {
		return kpid;
	}



	public String getKpcnt() {
		return kpcnt;
	}



	public String getKpprice() {
		return kpprice;
	}



	public String getKpdesc() {
		return kpdesc;
	}



	public String getKpcompany() {
		return kpcompany;
	}



	public String getKpimage() {
		return kpimage;
	}



	public String getKpname() {
		return kpname;
	}



	public String getKpdeleteyn() {
		return kpdeleteyn;
	}



	public String getKpinsertdate() {
		return kpinsertdate;
	}



	public String getKpupdatedate() {
		return kpupdatedate;
	}


	
	// setter
	public void setKpnum(String kpnum) {
		this.kpnum = kpnum;
	}



	public void setKpid(String kpid) {
		this.kpid = kpid;
	}



	public void setKpcnt(String kpcnt) {
		this.kpcnt = kpcnt;
	}



	public void setKpprice(String kpprice) {
		this.kpprice = kpprice;
	}



	public void setKpdesc(String kpdesc) {
		this.kpdesc = kpdesc;
	}



	public void setKpcompany(String kpcompany) {
		this.kpcompany = kpcompany;
	}



	public void setKpimage(String kpimage) {
		this.kpimage = kpimage;
	}



	public void setKpname(String kpname) {
		this.kpname = kpname;
	}



	public void setKpdeleteyn(String kpdeleteyn) {
		this.kpdeleteyn = kpdeleteyn;
	}



	public void setKpinsertdate(String kpinsertdate) {
		this.kpinsertdate = kpinsertdate;
	}



	public void setKpupdatedate(String kpupdatedate) {
		this.kpupdatedate = kpupdatedate;
	}
	
	
	
	// 페이징 getter

	public String getPageSize() {
		return pageSize;
	}



	public String getGroupSize() {
		return groupSize;
	}



	public String getCurPage() {
		return curPage;
	}



	public String getTotalCount() {
		return totalCount;
	}


	
	/// paging setter
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}



	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}



	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}



	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}



	public static void printVO(KosmoProductVO pvo) {
		
		logger.info("	글 번호는 ?	>>> : " + pvo.getKpnum());
		logger.info("	상품 아이디는 ?	>>> : " + pvo.getKpid());
		logger.info("	상품명은 ?	>>> : " + pvo.getKpname());
		logger.info("	상품 수량은	>>> : " + pvo.getKpcnt());
		logger.info("	상품 가격은	>>> : " + pvo.getKpprice());
		logger.info("	상품 설명은	>>> : " + pvo.getKpdesc());
		logger.info("	상품 제조사는	>>> : " + pvo.getKpcompany());
		logger.info("	상품 이미지 파일은	>>> : " + pvo.getKpimage());
		logger.info("	상품 삭제여부는	>>> : " + pvo.getKpdeleteyn());
		logger.info("	상품 등록일은	>>> : " + pvo.getKpinsertdate());
		logger.info("	상품 수정일은	>>> : " + pvo.getKpupdatedate());
	}
}
