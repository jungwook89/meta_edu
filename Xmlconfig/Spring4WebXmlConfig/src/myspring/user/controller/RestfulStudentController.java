package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myspring.student.dao.StudentDao;
import myspring.user.service.UserService;
import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;
import myspring.user.vo.UserVOXML;

@RestController
public class RestfulStudentController {
	@Autowired
	private StudentDao studentDao;

//	@RequestMapping(value = "/students", method = RequestMethod.GET)
//	public List<StudentVO> getStudentDeptByIdList() {
//		List<StudentVO> stuList = studentDao.selectStudentDeptById();
//		return stuList;
//	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<StudentVO> getStudentCourseStatusByIdList() {
		List<StudentVO> stuList = studentDao.selectStudentCourseStatusById();
		return stuList;
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public StudentVO getUser(@PathVariable int id) {
		StudentVO stu = studentDao.selectStudentById(id);
		return stu;
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public int insertUser(@RequestBody StudentVO student) {
			return studentDao.insertStudent(student);
	}

//	@RequestMapping(value = "/users", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
//	public Boolean updateUser(@RequestBody UserVO user) {
//		if (user != null) {
//			studentDao.updateUser(user);
//			return Boolean.TRUE;
//		} else {
//			return Boolean.FALSE;
//		}
//	}
//
//	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
//	public Boolean deleteUser(@PathVariable String id) {
//		if (id != null) {
//			studentDao.deleteUser(id);
//			return Boolean.TRUE;
//		} else {
//			return Boolean.FALSE;
//		}
//	}


}
