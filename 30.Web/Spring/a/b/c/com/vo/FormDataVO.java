package a.b.c.com.vo;

public class FormDataVO {
	
	private String datanum;
	private String dataid;
	private String datapw;
	private String dataname;
	
	public FormDataVO() {
		
		
	}
	
	public FormDataVO(String datanum, String dataid, String datapw, String dataname) {
		
		
		this.datanum = datanum;
		this.dataid = dataid;
		this.datapw = datapw;
		this.dataname = dataname;
		
	}

	public String getDatanum() {
		return datanum;
	}

	public String getDataid() {
		return dataid;
	}

	public String getDatapw() {
		return datapw;
	}

	public String getDataname() {
		return dataname;
	}

	
	
	public void setDatanum(String datanum) {
		this.datanum = datanum;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	public void setDatapw(String datapw) {
		this.datapw = datapw;
	}

	public void setDataname(String dataname) {
		this.dataname = dataname;
	}
	
}
