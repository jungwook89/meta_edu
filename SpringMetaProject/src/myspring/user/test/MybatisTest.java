package myspring.user.test;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.dao.UserDao;
import myspring.user.dao.mapper.StudentMapper;
import myspring.user.service.UserService;
import myspring.user.vo.DeptVO;
import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class MybatisTest {
	@Autowired
	DataSource datasource;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
	@Test
	public void service() {
		UserVO user = userService.getUser("5882");
		System.out.println(user);
	}
	
	@Test @Ignore
	public void dao() {
		UserVO user = userDao.read("jungwooks");
		System.out.println(user);
	}
	
	@Test @Ignore
	public void mapper() {
		StudentVO student = studentMapper.selectStudentById(5882);
		System.out.println(student);
	}
	
	@Test @Ignore
	public void insert() {
		UserVO user = new UserVO("jungwooks", "임정욱", "남자", "서울");
		int cnt = sqlSession.insert("userNS.insertUser",user);
		System.out.println("등록된 건수 : "+cnt);
		
		List<UserVO> userList = sqlSession.selectList("userNS.selectUserList");
		for (UserVO userVO : userList) {
			System.out.println(userVO);
		}
	}
	
	
	
	@Test @Ignore
	public void student() {
		List<StudentVO> studentList = sqlSession.selectList("studentNS.selectStudentDeptById","20");
		for (StudentVO studentVO : studentList) {
			System.out.println(studentVO);
		}
	}
	
	
	@Test @Ignore
	public void insertStudent() {
		StudentVO student = new StudentVO(5882, "임정욱", 31, "전임", "주간", new DeptVO(20));
		int cnt = sqlSession.insert("studentNS.insertStudent",student);
		System.out.println("적용된 줄은 :"+cnt);
	}
	
	@Test @Ignore
	public void select() {
		UserVO user = sqlSession.selectOne("userNS.selectUserById","gildong");
		System.out.println(user.getName());
	}
	
	@Test @Ignore
	public void mybatis() {
		System.out.println(sqlSessionFactory.getClass().getName());
	}
	

	@Test @Ignore
	public void conn() {
		try {
			Connection con = datasource.getConnection();
			System.out.println(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
