package xinxi;

import java.io.Serializable;

public class Grade implements Serializable{
	private String stunum;
	private String stuname;
	private String cname;
	private int stugrade;
	public String getStunum() {
		return stunum;
	}
	public void setStunum(String stunum) {
		this.stunum = stunum;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getStugrade() {
		return stugrade;
	}
	public void setStugrade(int stugrade) {
		this.stugrade = stugrade;
	}
}
