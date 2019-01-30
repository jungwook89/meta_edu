package com.mesim.bp.web.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mesim.bp.web.dto.BoardData;
import com.mesim.bp.web.service.BoardService;


@Controller
public class IndexController {
	
	@Autowired
    BoardService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView hello() throws SQLException {

		ModelAndView mav = new ModelAndView();
//		List<BoardData> boardList = new ArrayList<BoardData>();
//		boardList = service.getBoardList();
//		mav.addObject("boardList",boardList);
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping(value = "/nav/view/misun-kim", method = RequestMethod.GET)
	public ModelAndView dashboard() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("introduce/misun");
		return mav;
	}
	@RequestMapping(value = "/nav/view/jeonguk-im", method = RequestMethod.GET)
	public ModelAndView dashboard2() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("introduce/jeonguk");
		return mav;
	}
}
