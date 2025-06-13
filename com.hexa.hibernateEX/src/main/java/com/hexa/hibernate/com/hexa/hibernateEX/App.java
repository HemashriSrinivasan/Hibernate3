package com.hexa.hibernate.com.hexa.hibernateEX;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
 
 
 
/**
* Hello world!
*
*/
public class App
{
	
	SessionFactory  sessionFactory;  // interface
	
	Session  session;
	public App() {
		sessionFactory= new Configuration().configure("hiber.config.xml").addAnnotatedClass(Student.class).buildSessionFactory();
    	
    	session=sessionFactory.openSession();
	}
	
	
	void insert()
	{
		
    	Transaction txTransaction= session.beginTransaction();
    	
    	Student s= new Student();
    	s.setRollno(103);
    	s.setName("maha");
    	s.setMarks(10000.0);
    	
    	session.save(s);
    	txTransaction.commit();
	}
	
	
	void search(int rollno)
	{
		
    	session=sessionFactory.openSession();
    Student rs=	session.get(Student.class, rollno);
    if(rs!=null)
    {
    	System.out.println(rs.toString());
    }
    else {
    	System.out.println("Not Found");
 
    	
	}
    }
	/* void searchByName(String name)
	{
		
		session=sessionFactory.openSession();
		Student sr=session.find(Student.class, name);
		 if(sr!=null)
		    {
		    	System.out.println(sr.toString());
		    }
		    else {
		    	System.out.println("Not Found");
 
		    	
			}
	}	void searchByName(String name)
	{
		
		session=sessionFactory.openSession();
		Student sr=session.find(Student.class, name);
		 if(sr!=null)
		    {
		    	System.out.println(sr.toString());
		    }
		    else {
		    	System.out.println("Not Found");
 
		    	
			}
	}*/
	void removeByRollNo(int rno)
	{
	
		session=sessionFactory.openSession();
    	Transaction txTransaction= session.beginTransaction();
    	
    	Student r=session.find(Student.class, rno);
    	
    	if(r==null)
    	{
    		System.out.println("Not Found");
    	}
    	else {
    		
		
    	session.delete(r);
    		}
    		
    	txTransaction.commit();
 
	}
	void updateNameFee(int roll,double marks,String name)
	{
		
		session=sessionFactory.openSession();
    	Transaction txTransaction= session.beginTransaction();
    	
    	Student s= new Student();
    	s.setRollno(101);
    	s.setName(name);
    	s.setMarks(marks);
    	
    	session.update(s);
    	
    	txTransaction.commit();
 
    	
	}
	void findAndUpdate(int rollno,double marks)
	{
		session=sessionFactory.openSession();
    	Transaction txTransaction= session.beginTransaction();
    	
    	Student r=session.find(Student.class, rollno);
    	if (r != null) {
            r.setMarks(marks); 
            session.update(r); 
            txTransaction.commit();
            System.out.println("Student marks updated successfully!");
        } else {
            System.out.println("Student with rollno " + rollno + " not found.");
            }
		
	}
	
	 
 
	
	
    public static void main( String[] args )
    {
    	
    	
    	
    	
    App obj= new App();
    
    	//obj.insert();
    	//obj.search(102);
    //obj.removeByRollNo(102);
    //obj.updateNameFee(102, 80, "Hema");
    obj.findAndUpdate(103,944);
    	
    	
    	
    	
    	
        System.out.println( "Hello World!" );
    }
}