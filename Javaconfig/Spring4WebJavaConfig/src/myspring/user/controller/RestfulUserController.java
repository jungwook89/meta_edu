package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.UserVOXML;

@RestController
@RequestMapping("/users")
public class RestfulUserController {
	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<UserVO> getUserList() {
		List<UserVO> userList = userService.getUserList();
		return userList;
	}
	
	@RequestMapping(value="/{id}",
			                    method=RequestMethod.GET)
	@ResponseBody
	public UserVO getUser(@PathVariable String id) {
		UserVO user = userService.getUser(id);
		return user;
	}
		
	@RequestMapping(method=RequestMethod.POST,
			        headers = {"Content-type=application/json"})
	@ResponseBody
	public Boolean insertUser(@RequestBody UserVO user) {
		if (user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		} else {	
			return Boolean.FALSE;
		}
	}
	
	@RequestMapping( method=RequestMethod.PUT,
			         headers = {"Content-type=application/json"})
	@ResponseBody
	public Boolean updateUser(@RequestBody UserVO user) {
		if (user != null) {
			userService.updateUser(user);
			return Boolean.TRUE;
		} else {	
			return Boolean.FALSE;
		}
	}
	
	@RequestMapping(value="/{id}",
			         method=RequestMethod.DELETE)
	@ResponseBody
	public Boolean deleteUser(@PathVariable String id) {
		if (id != null) {
			userService.deleteUser(id);
			return Boolean.TRUE;
		} else {		
			return Boolean.FALSE;
		}
	}
	
	@RequestMapping(value="/usersXml",
			method=RequestMethod.GET)
	@ResponseBody
	public UserVOXML getUserListXml() {
		List<UserVO> list = userService.getUserList();
		UserVOXML xml = new UserVOXML("success", list);
		return xml;
	}	
}
