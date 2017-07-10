package com.baidu.manytomany;

import com.baidu.onetomany.Order;
import com.baidu.onetomany.OrderItem;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by dell on 2017/7/3.
 */
public class ManyToManyTest {
    @Test
    public void manyToManyTest() {
        //1,获取EntityManegerFactory,2获取EntityManeger对象进行事务管理和保存操作，3，关闭资源
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTest");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = new Student("张三");
        Teacher teacher = new Teacher("老师");
        //student.addTeacher(teacher);//不能级联添加
        em.persist(student);
        em.persist(teacher);
       /* Student student = new Student("ss");
        em.persist(student);*/
       // em.persist(new Teacher("老师"));
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
