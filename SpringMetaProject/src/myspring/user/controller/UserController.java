package myspring.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/getUser.do")
	public ModelAndView getUser(@RequestParam("userid") String id) {
		UserVO user = userService.getUser(id);
		ModelAndView mv = new ModelAndView("userInfo","userKey",user);
		return mv;
	}
	
	@RequestMapping("/getUserList.do")
	public String getUserList(Model model) {
		List<UserVO> userList = userService.getUserList();
		model.addAttribute("userList",userList);
		return "userList";
	}
	
	@RequestMapping("/insertUserForm.do")
	public String insertUserForm(HttpSession hs) {
		List<String> genderList = new ArrayList<String>();
		genderList.add("��");
		genderList.add("��");

		List<String> cityList = new ArrayList<String>();
		cityList.add("����");
		cityList.add("���");
		cityList.add("�λ�");
		cityList.add("�뱸");
		cityList.add("����");

		hs.setAttribute("genderList", genderList);
		hs.setAttribute("cityList", cityList);
//		Map<String, List<String>> map = new HashMap<>();
//		map.put("genderList", genderList);
//		map.put("cityList", cityList);

		return "userInsert";
	}
	
	@RequestMapping(value="/insertUser.do", method=RequestMethod.POST)
	public String insertUser(@ModelAttribute UserVO user) {
		if(user == null) {
			userService.insertUser(user);
		}
		return "redirect:/getUserList.do";
	}
}
