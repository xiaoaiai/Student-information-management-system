package xinxi;

import java.sql.ResultSet;
import java.util.*;

import jdbc.*;

public class Manager {
    Scanner input=new Scanner(System.in);
    /**
     * ������
     */
    public void menu(){
    	System.out.println("******************ѧ����Ϣ����ϵͳ*****************");
    	System.out.println();
    	System.out.println("\t\t1 ����Ա����");
    	System.out.println("\t\t2 ѧ������");
    	System.out.println();
    	System.out.println("***********************************************");
    	System.out.print("��ѡ��˵���");
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
    	System.out.print("���������Ա���ƣ�");
    	String name=input.next();
    	System.out.print("���������룺");
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
    		System.out.println("����Ա���ƻ����벻��ȷ����ȷ�Ϻ����µ�¼��");
    		loginad();
    	}
    }
    /**
     * ����Ա����
     * ѧ�����γ̣�ѡ�Σ��ɼ�������Ա
     * ��Ϣ����
     */
    public void menuad(){
    	System.out.println("------------------>>����Ա����>>---------------------");
    	System.out.print("\t\t1 ѧ����Ϣ����");
    	System.out.println("\t\t2 �γ���Ϣ����");
    	System.out.print("\t\t3 ѡ����Ϣ����");
    	System.out.println("\t\t4 �ɼ���Ϣ����");
    	System.out.print("\t\t5 ����Ա��Ϣ����");
    	System.out.println("\t\t6 ����������");
    	System.out.println("--------------------------------------------------");
    	System.out.print("��ѡ��˵���");
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
     * ѧ����Ϣ����
     * ���ӣ�ɾ�����޸ģ��鿴
     */
    public void studentmenu(){
    	System.out.println("----------------->>ѧ����Ϣ�������>>-----------------");
    	System.out.print("\t\t1 ѧ����Ϣ�鿴");
    	System.out.println("\t\t2 ���ѧ����Ϣ");
    	System.out.print("\t\t3 ɾ��ѧ����Ϣ");
    	System.out.println("\t\t4 �޸�ѧ����Ϣ");
    	System.out.print("\t\t5 ����ѧ����Ϣ");
    	System.out.println("\t\t6 ���ع���Ա����");
    	System.out.println("--------------------------------------------------");
    	System.out.print("��ѡ��˵���");
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
    	System.out.println("ѧ��\t����\t\t�Ա�\t����\t��ͥסַ\t\t\t���֤��\t\t\t�༶");
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
    	System.out.print("���������ѧ����ѧ�ţ�");
    	String num=input.next();s.setStunum(num);
    	System.out.print("���������ѧ����������");
    	String name=input.next();s.setName(name);
    	System.out.print("���������ѧ�����Ա�");
    	String sex=input.next();s.setSex(sex);
    	System.out.print("���������ѧ�������룺");
    	String pass=input.next();s.setPassword(pass);
    	System.out.print("���������ѧ���ļ�ͥסַ��");
    	String address=input.next();s.setAddress(address);
    	System.out.print("���������ѧ�������֤�ţ�");
    	String card=input.next();s.setIdentitycard(card);
    	System.out.print("���������ѧ���İ༶��");
    	String classname=input.next();s.setClassname(classname);
    	int count=0;
    	try {
			count=sd.saveinsert(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("���ѧ����Ϣ�ɹ���");
    	}else{
    		System.out.println("���ѧ����Ϣʧ�ܣ�");
    	}
    }
    
    public void deletestudent(){
    	StudentDao sd=new StudentDao();
    	Student s=new Student();
    	System.out.print("��������Ҫ�޸ĵ�ѧ��������");
    	String name=input.next();s.setName(name);
    	int count=0;
    	try {
			count=sd.savedelete(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("ɾ��ѧ����Ϣ�ɹ���");
    	}else{
    		System.out.println("ɾ��ѧ����Ϣʧ�ܣ�");
    	}
    }
    
    public void updatestudent(){
    	StudentDao sd=new StudentDao();
    	Student s=new Student();
    	System.out.print("��������Ҫ�޸ĵ�ѧ��������");
    	String name1=input.next();
    	System.out.print("�������޸ĺ��ѧ��ѧ�ţ�");
    	String num=input.next();s.setStunum(num);
    	System.out.print("�������޸ĺ��ѧ��������");
    	String name=input.next();s.setName(name);
    	System.out.print("�������޸ĺ��ѧ���Ա�");
    	String sex=input.next();s.setSex(sex);
    	System.out.print("�������޸ĺ��ѧ�����룺");
    	String pass=input.next();s.setPassword(pass);
    	System.out.print("�������޸ĺ��ѧ����ͥסַ��");
    	String address=input.next();s.setAddress(address);
    	System.out.print("�������޸ĺ��ѧ�����֤�ţ�");
    	String card=input.next();s.setIdentitycard(card);
    	System.out.print("�������޸ĺ��ѧ���༶��");
    	String classname=input.next();s.setClassname(classname);
    	int count=0;
    	try {
			count=sd.saveupdate(s, name1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("�޸�ѧ����Ϣ�ɹ���");
    	}else{
    		System.out.println("�޸�ѧ����Ϣʧ�ܣ�");
    	}
    }
    
    public void findstudent(){
    	StudentDao sd=new StudentDao();
    	System.out.print("��������Ҫ���ҵ�ѧ��������");
    	String name=input.next();
    	System.out.println("ѧ��\t\t����\t�Ա�\t����\t��ͥסַ\t\t\t���֤��\t\t\t�༶");
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
     * �γ���Ϣ����
     * ���ӣ�ɾ�����޸ģ��鿴
     */
    public void choosemenu(){
    	System.out.println("----------------->>�γ���Ϣ�������>>-----------------");
    	System.out.print("\t\t1 ѡ����Ϣ��ʾ");
    	System.out.println("\t\t2 ���ѡ����Ϣ");
    	System.out.print("\t\t3 ɾ��ѡ����Ϣ");
    	System.out.println("\t\t4 �޸�ѡ����Ϣ");
    	System.out.print("\t\t5 ����ѡ����Ϣ");
    	System.out.println("\t\t6 ���ع���Ա����");
    	System.out.println("--------------------------------------------------");
    	System.out.print("��ѡ��˵���");
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
    		System.out.print("��������Ҫ����ѡ����Ϣ��ѧ��������");
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
    	System.out.println("ѧ��\t����\t�ο���ʦ\t�γ�");
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
    	System.out.print("���������ѡ����Ϣѧ����ѧ�ţ�");
    	int id=input.nextInt();c.setStunum(id);
    	System.out.print("���������ѡ����Ϣѧ����������");
    	String name=input.next();c.setName(name);
    	System.out.print("���������ѡ����Ϣ���ο���ʦ��");
    	String teacher=input.next();c.setTeacher(teacher);
    	System.out.print("���������ѡ����Ϣ�γ̣�");
    	String cname=input.next();c.setCname(cname);
    	try {
			count=cd.saveinsert(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("���ѡ����Ϣ�ɹ���");
    	}else{
    		System.out.println("���ѡ����Ϣʧ�ܣ�");
    	}
    }
    
    public void deletechoose(){
    	ChooseDao cd=new ChooseDao();
    	Choose c=new Choose();
    	System.out.print("��������Ҫɾ��ѡ����Ϣ��ѧ��������");
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
			System.out.println("ɾ��ѡ����Ϣ�ɹ���");
		}else{
			System.out.println("ɾ��ѡ����Ϣʧ�ܣ�");
		}
    }
    
    public void updatechoose(){
    	ChooseDao cd=new ChooseDao();
    	int count=0;
    	Choose c=new Choose();
    	System.out.print("��������Ҫ�޸�ѡ����Ϣ��ѧ��������");
    	String name=input.next();c.setName(name);
    	System.out.print("�������޸ĺ��ѧ�ţ�");
    	int num=input.nextInt();c.setStunum(num);
    	System.out.print("�������޸ĺ�Ŀγ����ƣ�");
    	String cname=input.next();c.setName(cname);
    	System.out.print("�������޸ĺ�Ŀγ��ο���ʦ��");
    	String teacher=input.next();c.setTeacher(teacher);
    	try {
			count=cd.saveupdate(c, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("�޸Ŀγ���Ϣ�ɹ���");
    	}else{
    		System.out.println("�޸Ŀγ���Ϣʧ�ܣ�");
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
    			System.out.println("ѧ��\t����\t�ο���ʦ\t�γ�");
    			System.out.print(c.getStunum()+"\t");
    			System.out.print(c.getName()+"\t");
    			System.out.print(c.getTeacher()+"\t");
        		System.out.print(c.getCname()+"\n");
    		}
    	}
    	if(flag){
    		System.out.println("������"+name+"��ѡ�μ�¼����ȷ�Ϻ���в��ң�");
    		this.findchoose(name);
    	}
    }
    /**
     * 
     */
    public void coursemenu(){
    	System.out.println("----------------->>ѡ����Ϣ�������>>-----------------");
    	System.out.print("\t\t1 �γ���Ϣ��ʾ");
    	System.out.println("\t\t2 ���ҿγ���Ϣ");
    	System.out.print("\t\t3 ��ӿγ���Ϣ");
    	System.out.println("\t\t4 ɾ���γ���Ϣ");
    	System.out.print("\t\t5 �޸Ŀγ���Ϣ");
    	System.out.println("\t\t6 ���ع���Ա����");
    	System.out.println("--------------------------------------------------");
    	System.out.print("��ѡ��˵���");
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
    		System.out.println("���\t�ο���ʦ\t\t�γ�\t��ʱ��\t��ѡ����\t��ѡ����");
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
    	System.out.print("��������Ҫ���ҵĿγ�����");
    	String cname=input.next();
    	try {
			rs=cd.find(cname);
			while(rs.next())
	    	{
	    		System.out.println("���\t�ο���ʦ\t\t�γ�\t��ʱ��\t��ѡ����\t��ѡ����");
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
    	System.out.print("��������Ҫ��ӵĿγ̣�");
    	String name=input.next();
    	c.setCname(name);
    	System.out.print("��������Ҫ��ӿγ̵��ο���ʦ��");
    	String tname=input.next();
    	c.setTeacher(tname);
    	System.out.print("��������Ҫ��ӿγ̵���ѡ������");
    	int limit=input.nextInt();
    	c.setLimitnum(limit);
    	System.out.print("��������Ҫ��ӿγ̵���ѡ������");
    	int select=input.nextInt();
    	c.setSelectnum(select);
    	System.out.print("��������Ҫ��ӿγ̵�ѧʱ��");
    	int classhour=input.nextInt();
    	c.setClasshours(classhour);
    	try {
			count=cd.saveinsert(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("��ӿγ���Ϣ�ɹ���");
    	}else{
    		System.out.println("��ӿγ���Ϣʧ�ܣ�");
    	}
    }
    
    public void deletecourse(){
    	CourseDao cd=new CourseDao();
    	int count=0;
    	Course c=new Course();
    	System.out.print("��������Ҫɾ���γ���Ϣ�Ŀγ�����");
    	String name=input.next();
    	c.setCname(name);
    	try {
			count=cd.savedelete(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("ɾ���γ���Ϣ�ɹ���");
    	}else{
    		System.out.println("ɾ���γ���Ϣʧ�ܣ�");
    	}
    }
    
    public void updatecourse(){
    	CourseDao cd=new CourseDao();
    	int count=0;
    	Course c=new Course();
    	System.out.print("��������Ҫ�޸Ŀγ���Ϣ�Ŀγ�����");
    	String name=input.next();
    	System.out.print("�������޸ĺ�Ŀγ���");
    	String name1=input.next();
    	c.setCname(name1);
    	System.out.print("�������޸ĺ�Ŀγ��ο���ʦ��");
    	String tname=input.next();
    	c.setTeacher(tname);
    	System.out.print("�������޸ĺ�Ŀγ���ѡ������");
    	int limit=input.nextInt();
    	c.setLimitnum(limit);
    	System.out.print("�������޸ĺ�Ŀγ���ѡ������");
    	int select=input.nextInt();
    	c.setSelectnum(select);
    	System.out.print("�������޸ĺ�Ŀγ�ѧʱ��");
    	int classhour=input.nextInt();
    	c.setClasshours(classhour);
    	try {
			count=cd.saveupdate(c, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("�޸Ŀγ���Ϣ�ɹ���");
    	}else{
    		System.out.println("�޸Ŀγ���Ϣʧ�ܣ�");
    	}
    }
    /**
     * 
     */
    public void grademenu(){
    	System.out.println("----------------->>�ɼ���Ϣ�������>>-----------------");
    	System.out.print("\t\t1 �ɼ���Ϣ��ʾ");
    	System.out.println("\t\t2 ���ҳɼ���Ϣ");
    	System.out.print("\t\t3 �޸ĳɼ���Ϣ");
    	System.out.print("\t\t4 ��ӳɼ���Ϣ");
    	System.out.println("\t\t5 ���ع���Ա����");
    	System.out.println("--------------------------------------------------");
    	System.out.print("��ѡ��˵���");
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
    //�鿴����ѧ���ɼ�
    public void viewgrade(){
    	GradeDao gd=new GradeDao();
    	List<Grade> li=new ArrayList<Grade>();
    	try {
			li=gd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ѧ��\t\t����\t�γ�\t\t�ɼ�");
    	for(Grade g:li){
    		System.out.print(g.getStunum()+"\t");
    		System.out.print(g.getStuname()+"\t");
    		System.out.print(g.getCname()+"\t");
    		System.out.print(g.getStugrade()+"\n");
    	}
    }
    //���ѧ���ɼ���¼
    public void addgrade(){
    	GradeDao gd=new GradeDao();
    	System.out.println("��������Ҫ��ӳɼ���Ϣ��ѧ��������");
    	String name=input.next();
    	int count=0;
		Grade g=new Grade();
		g.setStuname(name);
		System.out.print("���������ѧ���ɼ���ѧ��ѧ�ţ�");
		String num=input.next();g.setStunum(num);
		System.out.print("���������ѧ���ɼ��Ŀγ�����");
		String cname=input.next();g.setCname(cname);
		System.out.print("���������ѧ���ɼ���ѧ���ɼ���");
		int grade=input.nextInt();g.setStugrade(grade);
		try {
			count=gd.saveinsert(g);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("��ӳɼ���Ϣ�ɹ���");
		}else{
			System.out.println("��ӳɼ���Ϣʧ�ܣ�");
		}		
    }
    //����ѧ���ɼ�
    public void findgrade(){
    	GradeDao gd=new GradeDao();
    	boolean flag=true;
    	System.out.print("��������Ҫ���ҳɼ���ѧ��������");
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
				System.out.println("ѧ��\t\t����\t�γ�\t\t�ɼ�");
				System.out.print(g.getStunum()+"\t");
				System.out.print(g.getStuname()+"\t");
				System.out.print(g.getCname()+"\t");
				System.out.print(g.getStugrade()+"\n");
			}
		}
		if(flag){
			System.out.println("������ѧ��"+name+"�ĳɼ���¼����ȷ�Ϻ���в��ң�");
			this.findgrade();
		}
    }
    //����ѧ���ɼ�
    public void updategrade(){
    	GradeDao gd=new GradeDao();
    	boolean flag=true;
    	System.out.println("��������Ҫ�޸ĳɼ���Ϣ��ѧ��������");
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
    			System.out.print("�������޸ĺ��ѧ�ţ�");
    			String num=input.next();g.setStunum(num);
    			System.out.print("�������޸ĺ��ѧ��������");
    			String name1=input.next();g.setStuname(name1);
    			System.out.print("�������޸ĺ�Ŀγ�����");
    			String cname=input.next();g.setCname(cname);
    			System.out.print("�������޸ĺ�ĳɼ���");
    			int grade=input.nextInt();g.setStugrade(grade);
    			try {
					count=gd.saveupdate(g, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("�޸ĳɼ���Ϣ�ɹ���");
				}else{
					System.out.println("�޸ĳɼ���Ϣʧ�ܣ�");
				}
    		}
    	}
    	if(flag){
    		System.out.println("������"+name+"�ĳɼ���Ϣ���޷������޸ģ����֤���ٽ����޸ģ�");
    		this.updategrade();
    	}
    }
    /**
     * ����Ա��Ϣ����
     * ���ӣ�ɾ�����޸�
     */
    public void adminmenu(){
    	System.out.println("----------------->>����Ա��Ϣ�������>>-----------------");
    	System.out.print("\t\t1  ����Ա��Ϣ��ʾ");
    	System.out.println("\t\t2  ��ӹ���Ա��Ϣ");
    	System.out.print("\t\t3  �޸Ĺ���Ա��Ϣ");
    	System.out.println("\t\t4  ɾ������Ա��Ϣ");
    	System.out.println("\t\t5 ���ع���Ա����");
    	System.out.println("--------------------------------------------------");
    	System.out.print("��ѡ��˵���");
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
    //�鿴���й���Ա��Ϣ
    public void viewadmin(){
    	CadminDao cd=new CadminDao();
    	List<Cadmin> li=new ArrayList<Cadmin>();
    	try {
			li=cd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����Ա�������£�");
		for(Cadmin c:li){
			System.out.print(c.getName()+"\t");
		}
    }
    //��ӹ���Ա��Ϣ
    public void addadmin(){
    	CadminDao cd=new CadminDao();
    	Cadmin c=new Cadmin();
    	System.out.print("��������ӹ���Ա�����ƣ�");
    	String name=input.next();c.setName(name);
    	System.out.print("��������ӹ���Ա������:");
    	String pass=input.next();c.setPassword(pass);
    	int count=0;
    	try {
			count=cd.saveinsert(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("��ӹ���Ա�ɹ���");
		}else{
			System.out.println("��ӹ���Աʧ�ܣ�");
		}
    }
    //�޸Ĺ���Ա��Ϣ
    public void updateadmin(){
    	CadminDao cd=new CadminDao();
    	System.out.print("��������Ҫ�޸���Ϣ�Ĺ���Ա���ƣ�");
    	String name=input.next();
    	Cadmin c=new Cadmin();
    	System.out.print("�������޸ĺ�����ƣ�");
    	String name1=input.next();c.setName(name1);
    	System.out.print("�������޸ĺ�����룺");
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
    		System.out.println("�޸Ĺ���Ա��Ϣ�ɹ���");
    	}else{
    		System.out.println("�޸Ĺ���Ա��Ϣʧ�ܣ�");
    	}
    }
    //ɾ������Ա��Ϣ
    public void deleteadmin(){
    	CadminDao cd=new CadminDao();
    	Cadmin c=new Cadmin();
    	System.out.print("��������Ҫɾ���Ĺ���Ա���ƣ�");
    	String name=input.next();c.setName(name);
    	int count=0;
    	try {
			count=cd.savedelete(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("ɾ������Ա��Ϣ�ɹ���");
		}else{
			System.out.println("ɾ������Ա��Ϣʧ�ܣ�");
		}
    }
    //ѧ����½
    public void loginstu(){
    	StudentDao sd=new StudentDao();
    	boolean flag=true;
    	List<Student> li=new ArrayList<Student>();
    	System.out.print("������ѧ��������");
    	String name=input.next();
    	System.out.print("���������룺");
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
    		System.out.println("�û��������벻��ȷ����ȷ�Ϻ����µ�¼��");
    		this.loginstu();
    	}
    }
    /**
     * ѧ������
     * @param name
     */
    public void menustu(String name){
    	System.out.println("------------------>>ѧ������>>---------------------");
    	System.out.print("\t\t1 ѧ����Ϣ�鿴");
    	System.out.println("\t\t2 �ɼ���Ϣ�鿴");
    	System.out.print("\t\t3 ������Ϣ����");
    	System.out.println("\t\t4 ����������");
    	System.out.println("--------------------------------------------------");
    	System.out.print("��ѡ��˵���");
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
    //�鿴ѧ����Ϣ
    public void viewstu(String name){
    	StudentDao sd=new StudentDao();
    	List<Student> li=new ArrayList<Student>();
    	try {
			li=sd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("ѧ��\t\t����\t�Ա�\t����\t\t��ͥסַ\t\t\t���֤��\t\t�༶");
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
    //�鿴ѧ���ɼ���Ϣ
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
    			System.out.println("ѧ��\t\t����\t�γ�\t�ɼ�");
    			System.out.print(g.getStunum()+"\t\t");
    			System.out.print(g.getStuname()+"\t");
    			System.out.print(g.getCname()+"\t");
    			System.out.println(g.getStugrade());
    		}
    	}
    }
    //����ѧ����Ϣ
    public void managestudent(String name){
    	System.out.println("------------------->>������Ϣ����------------------");
    	System.out.print("\t\t1 ���Ƹ�����Ϣ");
    	System.out.println("\t\t2 ѡ�޿γ�");
    	System.out.println("\t\t3 ��ѯѡ�޿γ�");
    	System.out.println("------------------------------------------------");
    	System.out.print("��ѡ��˵���");
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
    //���Ƹ�����Ϣ
    public void perfect(String name){
    	StudentDao sd=new StudentDao();
    	int count=0;
    	Student s=new Student();
    	System.out.print("������ѧ�ţ�");
    	String num=input.next();s.setStunum(num);
    	s.setName(name);
    	System.out.print("�������Ա�");
    	String sex=input.next();s.setSex(sex);
    	System.out.print("���������룺");
    	String pass=input.next();s.setPassword(pass);
    	System.out.print("�������ַ��");
    	String address=input.next();s.setAddress(address);
    	System.out.print("���������֤�ţ�");
    	String card=input.next();s.setIdentitycard(card);
    	System.out.print("������༶��");
    	String classname=input.next();s.setClassname(classname);
    	try {
			count=sd.saveupdate(s, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("������Ϣ�ɹ���");
    	}else{
    		System.out.println("������Ϣʧ�ܣ�");
    	}
    }
    //ѡ�޿γ�
    public void chooseclass(String name){
    	ChooseDao cd=new ChooseDao();
    	Choose c=new Choose();
    	ResultSet rs=null;
    	int count=0;
    	System.out.print("��������Ҫѡ�޵Ŀγ����ƣ�");
    	String cname=input.next();c.setCname(cname);
    	this.findcourse();
    	try {
			rs=cd.find(cname);
			while(rs.next()){
				if(rs.getInt(5)>rs.getInt(6)){
					System.out.print("������ѧ�ţ�");
					int num=input.nextInt();
					c.setStunum(num);
					c.setName(name);
					System.out.print("��ѡ���ον�ʦ��");
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
    		System.out.println("ѡ�γɹ���");
    	}else{
    		System.out.println("ѡ��ʧ�ܣ�");
    	}
    }
			
}
