package test;

import com.baidu.domain.Person;
import com.baidu.onetomany.OrderItem;
import com.mysql.jdbc.Driver;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by dell on 2017/7/2.
 */
public class PersonTest {
    @Test
    public void JpaTest() {
        //1,获取EntityManegerFactory,2获取EntityManeger对象进行事务管理和保存操作，3，关闭资源
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTest");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for (int i = 0; i < 5; i++) {
            em.persist(new Person("张三" + i));
        }
        //em.persist(new Person("张三"));

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    //cha查询方法两种
    @Test
    public void findMethod() {
        //第一种方法 find
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTest");
        EntityManager em = emf.createEntityManager();
        Person person1 = em.find(Person.class, 1);
        //System.out.println(person1.getName());
        Person person2 = em.getReference(Person.class, 2);
        System.out.println(person2.getName());
        em.close();
        emf.close();
    }
    //update的两种方法
    @Test
    public  void updateMethod() {
        //1,托管状态修改 还有游离状态修改
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTest");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, 1);
        person.setName("zhangsan999");
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
    //删除的方法
    @Test
    public void delete() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTest");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, 1);
        em.remove(person);//对象必须为托管对象
        em.getTransaction().commit();
        em.close();
        emf.close();
    }


}
