package xinxi;

import java.io.Serializable;

public class Course implements Serializable{
	private int id;
	private String teacher;
	private String cname;
	private int classhours;
	private int selectnum;
	private int limitnum;
	public int getSelectnum() {
		return selectnum;
	}
	public void setSelectnum(int selectnum) {
		this.selectnum = selectnum;
	}
	public int getLimitnum() {
		return limitnum;
	}
	public void setLimitnum(int limitnum) {
		this.limitnum =limitnum;
	}
	public int getClasshours() {
		return classhours;
	}
	public void setClasshours(int classhours) {
		this.classhours = classhours;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
