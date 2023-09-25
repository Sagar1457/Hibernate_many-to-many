package com.example.lab10;
//BVIDHYASAGAR..AF0320724
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.lab10.model.Cart;
import com.example.lab10.model.Product;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        
        try 
        {
        session.beginTransaction();
        Cart item1=new Cart();
        item1.setName("mobiles");
        
        Cart item2=new Cart();
        item2.setName("Electronic");
        
        Product p1=new Product();
        p1.setName(" power cable");
        
        Product p2=new Product();
        p2.setName("apple phone");
        
       item1.getItems().add(p1);
       item1.getItems().add(p2);
       item2.getItems().add(p1);
        
        session.save(item1);
        session.save(item2);
        session.save(p1);
        session.save(p2);
        session.getTransaction().commit();
        }
        finally 
        {
        	session.close();
        	sessionFactory.close();
        }    

    }
}
