package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Project started.." );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        // SessionFactory is a interface factory for providing session
        // type of connection , is a thread safe,
        SessionFactory factory = cfg.buildSessionFactory();

//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        // creating Student
        Student st=new Student();
        st.setId(101);
        st.setName("JOHN");
        st.setCity("Delhi");

        System.out.println(st);

        // creating object of address
        Address address=new Address();
        address.setStreet("street1");
        address.setCity("DELHI");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(12.34);

        // Reading image
//        FileInputStream fileInputStream=new FileInputStream("src\\main\\resources\\JPEG_example_JPG_RIP_001.jpg");
//        byte[] data=new byte[fileInputStream.available()];
//        fileInputStream.read(data);
//        address.setImage(data);

        Session currentSession = factory.openSession();
        ///
        Transaction beginTransaction = currentSession.beginTransaction();
        currentSession.save(st);
        currentSession.save(address);
        beginTransaction.commit();
        currentSession.close();
        System.out.println("Done");
    }
}
