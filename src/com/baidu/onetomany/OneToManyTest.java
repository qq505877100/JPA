package com.baidu.onetomany;

import com.baidu.domain.Person;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by dell on 2017/7/2.
 */
public class OneToManyTest {
    @Test
    public void oneToManyTest() {
        //1,获取EntityManegerFactory,2获取EntityManeger对象进行事务管理和保存操作，3，关闭资源
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTest");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        OrderItem orderItem1 = new OrderItem("足球", 90f);
        OrderItem orderItem2 = new OrderItem("篮球", 96f);
        Order order = new Order(990f);
        order.setId("100");
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);
        em.persist(order);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
