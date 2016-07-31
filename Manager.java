package xinxi;

import java.sql.ResultSet;
import java.util.*;

import jdbc.*;

public class Manager {
    Scanner input=new Scanner(System.in);
    /**
     * 主界面
     */
    public void menu(){
    	System.out.println("******************学生信息管理系统*****************");
    	System.out.println();
    	System.out.println("\t\t1 管理员界面");
    	System.out.println("\t\t2 学生界面");
    	System.out.println();
    	System.out.println("***********************************************");
    	System.out.print("请选择菜单：");
    	int choose=input.nextInt();
    	switch(choose){
    	case 1:
    		this.loginad();
    		this.menu();
    		break;
    	case 2:
    		this.loginstu();
    		menu();
    		break;
    	default:
    		this.menu();
    		break;
    	}
    }
    
    public void loginad(){
    	CadminDao cd=new CadminDao();
    	boolean flag=true;
    	List<Cadmin> li=new ArrayList<Cadmin>();
    	System.out.print("请输入管理员名称：");
    	String name=input.next();
    	System.out.print("请输入密码：");
    	String pass=input.next();
    	try {
			li=cd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(Cadmin c:li){
    		if(c.getName().equals(name)&&c.getPassword().equals(pass)){
    			flag=false;
    			menuad();
    		}
    	}
    	if(flag){
    		System.out.println("管理员名称或密码不正确，请确认后重新登录！");
    		loginad();
    	}
    }
    /**
     * 管理员界面
     * 学生，课程，选课，成绩，管理员
     * 信息管理
     */
    public void menuad(){
    	System.out.println("------------------>>管理员界面>>---------------------");
    	System.out.print("\t\t1 学生信息管理");
    	System.out.println("\t\t2 课程信息管理");
    	System.out.print("\t\t3 选课信息管理");
    	System.out.println("\t\t4 成绩信息管理");
    	System.out.print("\t\t5 管理员信息管理");
    	System.out.println("\t\t6 返回主界面");
    	System.out.println("--------------------------------------------------");
    	System.out.print("请选择菜单：");
    	int choose=input.nextInt();
    	switch(choose){
    	case 1:
    		this.studentmenu();
    		this.menuad();
    		break;
    	case 2:
    		this.coursemenu();
    		this.menuad();
    		break;
    	case 3:
    		this.choosemenu();
    		this.menuad();
    		break;
    	case 4:
    		this.grademenu();
    		this.menuad();
    		break;
    	case 5:
    		this.adminmenu();
    		this.menuad();
    		break;
    	default:
    		this.menu();break;
    	}
    }
    /**
     * 学生信息管理
     * 增加，删除，修改，查看
     */
    public void studentmenu(){
    	System.out.println("----------------->>学生信息管理界面>>-----------------");
    	System.out.print("\t\t1 学生信息查看");
    	System.out.println("\t\t2 添加学生信息");
    	System.out.print("\t\t3 删除学生信息");
    	System.out.println("\t\t4 修改学生信息");
    	System.out.print("\t\t5 查找学生信息");
    	System.out.println("\t\t6 返回管理员界面");
    	System.out.println("--------------------------------------------------");
    	System.out.print("请选择菜单：");
    	int choose=input.nextInt();
    	switch(choose){
    	case 1:
    		this.viewstudent();
    		this.studentmenu();
    		break;
    	case 2:
    		this.addstudent();
    		this.studentmenu();
    		break;
    	case 3:
    		this.deletestudent();
    		this.studentmenu();
    		break;
    	case 4:
    		this.updatestudent();
    		this.studentmenu();
    		break;
    	case 5:
    		this.findstudent();
    		this.studentmenu();
    		break;
    	default:
    		this.menuad();
    		break;
    	}
    }
    public void viewstudent(){
    	StudentDao sd=new StudentDao();
    	List<Student> li=new ArrayList<Student>();
    	try {
			li=sd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("学号\t姓名\t\t性别\t密码\t家庭住址\t\t\t身份证号\t\t\t班级");
    	for(Student s:li){
    		System.out.print(s.getStunum()+"\t");
    		System.out.print(s.getName()+"\t\t");
    		System.out.print(s.getSex()+"\t");
    		System.out.print(s.getPassword()+"\t");
    		System.out.print(s.getAddress()+"\t\t");
    		System.out.print(s.getIdentitycard()+"\t\t");
    		System.out.print(s.getClassname()+"\n");
    	}
    }
    
    public void addstudent(){
    	StudentDao sd=new StudentDao();
    	Student s=new Student();
    	System.out.print("请输入添加学生的学号：");
    	String num=input.next();s.setStunum(num);
    	System.out.print("请输入添加学生的姓名：");
    	String name=input.next();s.setName(name);
    	System.out.print("请输入添加学生的性别：");
    	String sex=input.next();s.setSex(sex);
    	System.out.print("请输入添加学生的密码：");
    	String pass=input.next();s.setPassword(pass);
    	System.out.print("请输入添加学生的家庭住址：");
    	String address=input.next();s.setAddress(address);
    	System.out.print("请输入添加学生的身份证号：");
    	String card=input.next();s.setIdentitycard(card);
    	System.out.print("请输入添加学生的班级：");
    	String classname=input.next();s.setClassname(classname);
    	int count=0;
    	try {
			count=sd.saveinsert(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("添加学生信息成功！");
    	}else{
    		System.out.println("添加学生信息失败！");
    	}
    }
    
    public void deletestudent(){
    	StudentDao sd=new StudentDao();
    	Student s=new Student();
    	System.out.print("请输入需要修改的学生姓名：");
    	String name=input.next();s.setName(name);
    	int count=0;
    	try {
			count=sd.savedelete(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("删除学生信息成功！");
    	}else{
    		System.out.println("删除学生信息失败！");
    	}
    }
    
    public void updatestudent(){
    	StudentDao sd=new StudentDao();
    	Student s=new Student();
    	System.out.print("请输入需要修改的学生姓名：");
    	String name1=input.next();
    	System.out.print("请输入修改后的学生学号：");
    	String num=input.next();s.setStunum(num);
    	System.out.print("请输入修改后的学生姓名：");
    	String name=input.next();s.setName(name);
    	System.out.print("请输入修改后的学生性别：");
    	String sex=input.next();s.setSex(sex);
    	System.out.print("请输入修改后的学生密码：");
    	String pass=input.next();s.setPassword(pass);
    	System.out.print("请输入修改后的学生家庭住址：");
    	String address=input.next();s.setAddress(address);
    	System.out.print("请输入修改后的学生身份证号：");
    	String card=input.next();s.setIdentitycard(card);
    	System.out.print("请输入修改后的学生班级：");
    	String classname=input.next();s.setClassname(classname);
    	int count=0;
    	try {
			count=sd.saveupdate(s, name1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("修改学生信息成功！");
    	}else{
    		System.out.println("修改学生信息失败！");
    	}
    }
    
    public void findstudent(){
    	StudentDao sd=new StudentDao();
    	System.out.print("请输入需要查找的学生姓名：");
    	String name=input.next();
    	System.out.println("学号\t\t姓名\t性别\t密码\t家庭住址\t\t\t身份证号\t\t\t班级");
    	try {
			ResultSet rs=sd.find(name);
			while(rs.next()){
				System.out.print(rs.getString(1)+"\t\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t\t");
				System.out.print(rs.getString(6)+"\t\t");
				System.out.print(rs.getString(7)+"\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * 课程信息管理
     * 增加，删除，修改，查看
     */
    public void choosemenu(){
    	System.out.println("----------------->>课程信息管理界面>>-----------------");
    	System.out.print("\t\t1 选课信息显示");
    	System.out.println("\t\t2 添加选课信息");
    	System.out.print("\t\t3 删除选课信息");
    	System.out.println("\t\t4 修改选课信息");
    	System.out.print("\t\t5 查找选课信息");
    	System.out.println("\t\t6 返回管理员界面");
    	System.out.println("--------------------------------------------------");
    	System.out.print("请选择菜单：");
    	int choose=input.nextInt();
    	switch(choose){
    	case 1:
    		this.viewchoose();
    		this.choosemenu();break;
    	case 2:
    		this.addchoose();
    		this.choosemenu();
    		break;
    	case 3:
    		this.deletechoose();
    		this.choosemenu();
    		break;
    	case 4:
    		this.updatechoose();
    		this.choosemenu();
    		break;
    	case 5:
    	{
    		System.out.print("请输入需要查找选课信息的学生姓名：");
        	String name=input.next();
    		this.findchoose(name);
    		this.choosemenu();
    		break;
    	}
    	default:
    		this.menuad();
    		break;
    	}
     }
    
     public void viewchoose(){
    	ChooseDao cd=new ChooseDao();
    	List<Choose> li=new ArrayList<Choose>();
    	try {
			li=cd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("学号\t姓名\t任课老师\t课程");
    	for(Choose c:li){
    		System.out.print(c.getStunum()+"\t");
    		System.out.print(c.getName()+"\t");
    		System.out.print(c.getTeacher()+"\t");
    		System.out.print(c.getCname()+"\n");
    	}
    }
    
    public void addchoose(){
    	ChooseDao cd=new ChooseDao();
    	int count=0;
    	Choose c=new Choose();
    	System.out.print("请输入添加选课信息学生的学号：");
    	int id=input.nextInt();c.setStunum(id);
    	System.out.print("请输入添加选课信息学生的姓名：");
    	String name=input.next();c.setName(name);
    	System.out.print("请输入添加选课信息的任课老师：");
    	String teacher=input.next();c.setTeacher(teacher);
    	System.out.print("请输入添加选课信息课程：");
    	String cname=input.next();c.setCname(cname);
    	try {
			count=cd.saveinsert(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("添加选课信息成功！");
    	}else{
    		System.out.println("添加选课信息失败！");
    	}
    }
    
    public void deletechoose(){
    	ChooseDao cd=new ChooseDao();
    	Choose c=new Choose();
    	System.out.print("请输入需要删除选课信息的学生姓名：");
    	String name=input.next();
    	c.setName(name);
    	int count=0;
    	try {
			count=cd.savedelete(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("删除选课信息成功！");
		}else{
			System.out.println("删除选课信息失败！");
		}
    }
    
    public void updatechoose(){
    	ChooseDao cd=new ChooseDao();
    	int count=0;
    	Choose c=new Choose();
    	System.out.print("请输入需要修改选课信息的学生姓名：");
    	String name=input.next();c.setName(name);
    	System.out.print("请输入修改后的学号：");
    	int num=input.nextInt();c.setStunum(num);
    	System.out.print("请输入修改后的课程名称：");
    	String cname=input.next();c.setName(cname);
    	System.out.print("请输入修改后的课程任课老师：");
    	String teacher=input.next();c.setTeacher(teacher);
    	try {
			count=cd.saveupdate(c, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("修改课程信息成功！");
    	}else{
    		System.out.println("修改课程信息失败！");
    	}
    }
    
    public void findchoose(String name){
    	ChooseDao cd=new ChooseDao();
    	boolean flag=true;
    	List<Choose> li=new ArrayList<Choose>();
    	try {
			li=cd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(Choose c:li){
    		if(c.getName().equals(name)){
    			flag=false;
    			System.out.println("学号\t姓名\t任课老师\t课程");
    			System.out.print(c.getStunum()+"\t");
    			System.out.print(c.getName()+"\t");
    			System.out.print(c.getTeacher()+"\t");
        		System.out.print(c.getCname()+"\n");
    		}
    	}
    	if(flag){
    		System.out.println("不存在"+name+"的选课记录，请确认后进行查找！");
    		this.findchoose(name);
    	}
    }
    /**
     * 
     */
    public void coursemenu(){
    	System.out.println("----------------->>选课信息管理界面>>-----------------");
    	System.out.print("\t\t1 课程信息显示");
    	System.out.println("\t\t2 查找课程信息");
    	System.out.print("\t\t3 添加课程信息");
    	System.out.println("\t\t4 删除课程信息");
    	System.out.print("\t\t5 修改课程信息");
    	System.out.println("\t\t6 返回管理员界面");
    	System.out.println("--------------------------------------------------");
    	System.out.print("请选择菜单：");
    	int choose=input.nextInt();
    	switch(choose){
    	case 1:
    		this.viewcourse();
    		this.coursemenu();
    		break;
    	case 2:{
    		this.findcourse();
    		this.coursemenu();
    		break;
    	}
    	case 3:
    		this.addcourse();
    		this.coursemenu();
    		break;
    	case 4:
    		this.deletecourse();
    		this.coursemenu();
    		break;
    	case 5:
    		this.updatecourse();
    		this.coursemenu();
    		break;
    	default:{menuad();break;}
    	}
    }
    
    public void viewcourse(){
    	CourseDao cd=new CourseDao();
    	List<Course> li=new ArrayList<Course>();
    	try {
			li=cd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(Course c:li){
    		System.out.println("编号\t任课老师\t\t课程\t课时数\t限选人数\t已选人数");
    		System.out.print(c.getId()+"\t");
    		System.out.print(c.getTeacher()+"\t\t");
    		System.out.print(c.getCname()+"\t");
    		System.out.print(c.getClasshours()+"\t");
    		System.out.print(c.getLimitnum()+"\t");
    		System.out.print(c.getSelectnum()+"\n");
    	}
    }
    
    public void findcourse(){
    	CourseDao cd=new CourseDao();
    	ResultSet rs=null;
    	System.out.print("请输入需要查找的课程名：");
    	String cname=input.next();
    	try {
			rs=cd.find(cname);
			while(rs.next())
	    	{
	    		System.out.println("编号\t任课老师\t\t课程\t课时数\t限选人数\t已选人数");
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getInt(4)+"\t");
				System.out.print(rs.getInt(5)+"\t");
	    		System.out.print(rs.getInt(6)+"\n");
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void addcourse(){
    	CourseDao cd=new CourseDao();
    	int count=0;
    	Course c=new Course();
    	System.out.print("请输入需要添加的课程：");
    	String name=input.next();
    	c.setCname(name);
    	System.out.print("请输入需要添加课程的任课老师：");
    	String tname=input.next();
    	c.setTeacher(tname);
    	System.out.print("请输入需要添加课程的限选人数：");
    	int limit=input.nextInt();
    	c.setLimitnum(limit);
    	System.out.print("请输入需要添加课程的已选人数：");
    	int select=input.nextInt();
    	c.setSelectnum(select);
    	System.out.print("请输入需要添加课程的学时：");
    	int classhour=input.nextInt();
    	c.setClasshours(classhour);
    	try {
			count=cd.saveinsert(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("添加课程信息成功！");
    	}else{
    		System.out.println("添加课程信息失败！");
    	}
    }
    
    public void deletecourse(){
    	CourseDao cd=new CourseDao();
    	int count=0;
    	Course c=new Course();
    	System.out.print("请输入需要删除课程信息的课程名：");
    	String name=input.next();
    	c.setCname(name);
    	try {
			count=cd.savedelete(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("删除课程信息成功！");
    	}else{
    		System.out.println("删除课程信息失败！");
    	}
    }
    
    public void updatecourse(){
    	CourseDao cd=new CourseDao();
    	int count=0;
    	Course c=new Course();
    	System.out.print("请输入需要修改课程信息的课程名：");
    	String name=input.next();
    	System.out.print("请输入修改后的课程名");
    	String name1=input.next();
    	c.setCname(name1);
    	System.out.print("请输入修改后的课程任课老师：");
    	String tname=input.next();
    	c.setTeacher(tname);
    	System.out.print("请输入修改后的课程限选人数：");
    	int limit=input.nextInt();
    	c.setLimitnum(limit);
    	System.out.print("请输入修改后的课程已选人数：");
    	int select=input.nextInt();
    	c.setSelectnum(select);
    	System.out.print("请输入修改后的课程学时：");
    	int classhour=input.nextInt();
    	c.setClasshours(classhour);
    	try {
			count=cd.saveupdate(c, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("修改课程信息成功！");
    	}else{
    		System.out.println("修改课程信息失败！");
    	}
    }
    /**
     * 
     */
    public void grademenu(){
    	System.out.println("----------------->>成绩信息管理界面>>-----------------");
    	System.out.print("\t\t1 成绩信息显示");
    	System.out.println("\t\t2 查找成绩信息");
    	System.out.print("\t\t3 修改成绩信息");
    	System.out.print("\t\t4 添加成绩信息");
    	System.out.println("\t\t5 返回管理员界面");
    	System.out.println("--------------------------------------------------");
    	System.out.print("请选择菜单：");
    	int choose=input.nextInt();
    	switch(choose){
    	case 1:
    		this.viewgrade();
    		this.grademenu();
    		break;
    	case 2:
    		this.findgrade();
    		this.grademenu();
    		break;
    	case 3:
    		this.updategrade();
    		this.grademenu();
    		break;
    	case 4:
    		this.addgrade();
    		this.grademenu();
    		break;
    	default:
    		this.menuad();break;
    	}
    }
    //查看所有学生成绩
    public void viewgrade(){
    	GradeDao gd=new GradeDao();
    	List<Grade> li=new ArrayList<Grade>();
    	try {
			li=gd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("学号\t\t姓名\t课程\t\t成绩");
    	for(Grade g:li){
    		System.out.print(g.getStunum()+"\t");
    		System.out.print(g.getStuname()+"\t");
    		System.out.print(g.getCname()+"\t");
    		System.out.print(g.getStugrade()+"\n");
    	}
    }
    //添加学生成绩记录
    public void addgrade(){
    	GradeDao gd=new GradeDao();
    	System.out.println("请输入需要添加成绩信息的学生姓名：");
    	String name=input.next();
    	int count=0;
		Grade g=new Grade();
		g.setStuname(name);
		System.out.print("请输入添加学生成绩的学生学号：");
		String num=input.next();g.setStunum(num);
		System.out.print("请输入添加学生成绩的课程名：");
		String cname=input.next();g.setCname(cname);
		System.out.print("请输入添加学生成绩的学生成绩：");
		int grade=input.nextInt();g.setStugrade(grade);
		try {
			count=gd.saveinsert(g);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("添加成绩信息成功！");
		}else{
			System.out.println("添加成绩信息失败！");
		}		
    }
    //查找学生成绩
    public void findgrade(){
    	GradeDao gd=new GradeDao();
    	boolean flag=true;
    	System.out.print("请输入需要查找成绩的学生姓名：");
    	String name=input.next();
    	List<Grade> li=new ArrayList<Grade>();
    	try {
			li=gd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Grade g:li){
			if(g.getStuname().equals(name)){
				flag=false;
				System.out.println("学号\t\t姓名\t课程\t\t成绩");
				System.out.print(g.getStunum()+"\t");
				System.out.print(g.getStuname()+"\t");
				System.out.print(g.getCname()+"\t");
				System.out.print(g.getStugrade()+"\n");
			}
		}
		if(flag){
			System.out.println("不存在学生"+name+"的成绩记录，请确认后进行查找！");
			this.findgrade();
		}
    }
    //更改学生成绩
    public void updategrade(){
    	GradeDao gd=new GradeDao();
    	boolean flag=true;
    	System.out.println("请输入需要修改成绩信息的学生姓名：");
    	String name=input.next();
    	int count=0;
    	List<Grade> li=new ArrayList<Grade>();
    	try {
			li=gd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(Grade g1:li){
    		if(g1.getStuname().equals(name)){
    			flag=false;
    			Grade g=new Grade();
    			System.out.print("请输入修改后的学号：");
    			String num=input.next();g.setStunum(num);
    			System.out.print("请输入修改后的学生姓名：");
    			String name1=input.next();g.setStuname(name1);
    			System.out.print("请输入修改后的课程名：");
    			String cname=input.next();g.setCname(cname);
    			System.out.print("请输入修改后的成绩：");
    			int grade=input.nextInt();g.setStugrade(grade);
    			try {
					count=gd.saveupdate(g, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("修改成绩信息成功！");
				}else{
					System.out.println("修改成绩信息失败！");
				}
    		}
    	}
    	if(flag){
    		System.out.println("不存在"+name+"的成绩信息，无法进行修改，请查证后再进行修改！");
    		this.updategrade();
    	}
    }
    /**
     * 管理员信息管理
     * 增加，删除，修改
     */
    public void adminmenu(){
    	System.out.println("----------------->>管理员信息管理界面>>-----------------");
    	System.out.print("\t\t1  管理员信息显示");
    	System.out.println("\t\t2  添加管理员信息");
    	System.out.print("\t\t3  修改管理员信息");
    	System.out.println("\t\t4  删除管理员信息");
    	System.out.println("\t\t5 返回管理员界面");
    	System.out.println("--------------------------------------------------");
    	System.out.print("请选择菜单：");
    	int choose=input.nextInt();
    	switch(choose){
    	case 1:
    		this.viewadmin();
    		this.adminmenu();
    		break;
    	case 2:
    		this.addadmin();
    		this.adminmenu();
    		break;
    	case 3:
    		this.updateadmin();
    		this.adminmenu();
    		break;
    	case 4:
    		this.deleteadmin();
    		this.adminmenu();
    		break;
    	default:
    		this.menuad();
    		break;
    	}
    }
    //查看所有管理员信息
    public void viewadmin(){
    	CadminDao cd=new CadminDao();
    	List<Cadmin> li=new ArrayList<Cadmin>();
    	try {
			li=cd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("管理员名单如下：");
		for(Cadmin c:li){
			System.out.print(c.getName()+"\t");
		}
    }
    //添加管理员信息
    public void addadmin(){
    	CadminDao cd=new CadminDao();
    	Cadmin c=new Cadmin();
    	System.out.print("请输入添加管理员的名称：");
    	String name=input.next();c.setName(name);
    	System.out.print("请输入添加管理员的密码:");
    	String pass=input.next();c.setPassword(pass);
    	int count=0;
    	try {
			count=cd.saveinsert(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("添加管理员成功！");
		}else{
			System.out.println("添加管理员失败！");
		}
    }
    //修改管理员信息
    public void updateadmin(){
    	CadminDao cd=new CadminDao();
    	System.out.print("请输入需要修改信息的管理员名称：");
    	String name=input.next();
    	Cadmin c=new Cadmin();
    	System.out.print("请输入修改后的名称：");
    	String name1=input.next();c.setName(name1);
    	System.out.print("请输入修改后的密码：");
    	String pass=input.next();
    	c.setPassword(pass);
    	int count=0;
    	try {
			count=cd.saveupdate(c, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("修改管理员信息成功！");
    	}else{
    		System.out.println("修改管理员信息失败！");
    	}
    }
    //删除管理员信息
    public void deleteadmin(){
    	CadminDao cd=new CadminDao();
    	Cadmin c=new Cadmin();
    	System.out.print("请输入需要删除的管理员名称：");
    	String name=input.next();c.setName(name);
    	int count=0;
    	try {
			count=cd.savedelete(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("删除管理员信息成功！");
		}else{
			System.out.println("删除管理员信息失败！");
		}
    }
    //学生登陆
    public void loginstu(){
    	StudentDao sd=new StudentDao();
    	boolean flag=true;
    	List<Student> li=new ArrayList<Student>();
    	System.out.print("请输入学生姓名：");
    	String name=input.next();
    	System.out.print("请输入密码：");
    	String pass=input.next();
    	try {
			li=sd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(Student s:li){
    		if(s.getName().equals(name)&&s.getPassword().equals(pass)){
    			flag=false;
    			menustu(name);
    		}
    	}
    	if(flag){
    		System.out.println("用户名或密码不正确，请确认后重新登录！");
    		this.loginstu();
    	}
    }
    /**
     * 学生界面
     * @param name
     */
    public void menustu(String name){
    	System.out.println("------------------>>学生界面>>---------------------");
    	System.out.print("\t\t1 学生信息查看");
    	System.out.println("\t\t2 成绩信息查看");
    	System.out.print("\t\t3 个人信息管理");
    	System.out.println("\t\t4 返回主界面");
    	System.out.println("--------------------------------------------------");
    	System.out.print("请选择菜单：");
    	int choose=input.nextInt();
    	switch(choose){
    	case 1:
    		this.viewstu(name);
    		this.menustu(name);
    		break;
    	case 2:
    		this.viewgrade(name);
    		this.menustu(name);
    		break;
    	case 3:
    		this.managestudent(name);
    		this.menustu(name);
    		break;
    	default:
    		this.menu();
    		break;
    	}
    }
    //查看学生信息
    public void viewstu(String name){
    	StudentDao sd=new StudentDao();
    	List<Student> li=new ArrayList<Student>();
    	try {
			li=sd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("学号\t\t姓名\t性别\t密码\t\t家庭住址\t\t\t身份证号\t\t班级");
    	for(Student s:li){
    		if(name.equals(s.getName())){
    			System.out.print(s.getStunum()+"\t\t");
    			System.out.print(s.getName()+"\t");
    			System.out.print(s.getSex()+"\t");
    			System.out.print(s.getPassword()+"\t\t");
    			System.out.print(s.getAddress()+"\t\t");
    			System.out.print(s.getIdentitycard()+"\t\t");
    			System.out.print(s.getClassname()+"\n");
    		}
    	}
    }
    //查看学生成绩信息
    public void viewgrade(String name){
    	GradeDao gd=new GradeDao();
    	List<Grade> li=new ArrayList<Grade>();
    	try {
			li=gd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(Grade g:li){
    		if(g.getStuname().equals(name)){
    			System.out.println("学号\t\t姓名\t课程\t成绩");
    			System.out.print(g.getStunum()+"\t\t");
    			System.out.print(g.getStuname()+"\t");
    			System.out.print(g.getCname()+"\t");
    			System.out.println(g.getStugrade());
    		}
    	}
    }
    //管理学生信息
    public void managestudent(String name){
    	System.out.println("------------------->>个人信息管理------------------");
    	System.out.print("\t\t1 完善个人信息");
    	System.out.println("\t\t2 选修课程");
    	System.out.println("\t\t3 查询选修课程");
    	System.out.println("------------------------------------------------");
    	System.out.print("请选择菜单：");
    	int choose=input.nextInt();
    	switch(choose){
    	case 1:
    		this.perfect(name);
    		this.managestudent(name);
    		break;
    	case 2:
    		this.chooseclass(name);
    		this.managestudent(name);
    		break;
    	case 3:
    	{
    		this.findchoose(name);
    		this.managestudent(name);
    		break;
    	}
    	default:
    		this.managestudent(name);
    		break;
    	}
    } 
    //完善个人信息
    public void perfect(String name){
    	StudentDao sd=new StudentDao();
    	int count=0;
    	Student s=new Student();
    	System.out.print("请输入学号：");
    	String num=input.next();s.setStunum(num);
    	s.setName(name);
    	System.out.print("请输入性别：");
    	String sex=input.next();s.setSex(sex);
    	System.out.print("请输入密码：");
    	String pass=input.next();s.setPassword(pass);
    	System.out.print("请输入地址：");
    	String address=input.next();s.setAddress(address);
    	System.out.print("请输入身份证号：");
    	String card=input.next();s.setIdentitycard(card);
    	System.out.print("请输入班级：");
    	String classname=input.next();s.setClassname(classname);
    	try {
			count=sd.saveupdate(s, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("完善信息成功！");
    	}else{
    		System.out.println("完善信息失败！");
    	}
    }
    //选修课程
    public void chooseclass(String name){
    	ChooseDao cd=new ChooseDao();
    	Choose c=new Choose();
    	ResultSet rs=null;
    	int count=0;
    	System.out.print("请输入需要选修的课程名称：");
    	String cname=input.next();c.setCname(cname);
    	this.findcourse();
    	try {
			rs=cd.find(cname);
			while(rs.next()){
				if(rs.getInt(5)>rs.getInt(6)){
					System.out.print("请输入学号：");
					int num=input.nextInt();
					c.setStunum(num);
					c.setName(name);
					System.out.print("请选择任课教师：");
					String teacher=input.next();
					c.setTeacher(teacher);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			count=cd.saveinsert(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("选课成功！");
    	}else{
    		System.out.println("选课失败！");
    	}
    }
			
}
