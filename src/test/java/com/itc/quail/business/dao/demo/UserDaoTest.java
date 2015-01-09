/**
 * 
 */
package com.itc.quail.business.dao.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itc.quail.business.pojo.demo.User;

/**
 * @author Administartor
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext.xml"})
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao ;

	/**
	 * Test method for {@link com.itc.quail.business.dao.demo.UserDao#save(com.itc.quail.business.pojo.demo.User)}.
	 */
	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.itc.quail.business.dao.demo.UserDao#getUserById(java.lang.String)}.
	 */
	@Test
	public void testGetUserById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.itc.quail.business.dao.demo.UserDao#getUsers()}.
	 */
	@Test
	public void testGetUsers() {
		List<User> list = userDao.getUsers();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getName()+"  "+list.get(i).getAge());
		}
		System.out.println(list.size());
	}

}
