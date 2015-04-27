package com.yoyo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yoyo.domain.CarConnSchool;
import com.yoyo.service.CarConnSchoolService;
import com.yoyo.service.CarConnTagService;
import com.yoyo.service.CarSchoolService;
import com.yoyo.service.CommentService;

@Controller
public class CarSchoolController extends BaseController{
	@Autowired
	CarConnSchoolService carConnSchoolService;
	
	@Autowired
	CarSchoolService carSchoolService;
	
	@Autowired
	CarConnTagService carConnTagService;
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/carschool/index", method = RequestMethod.GET)
	public String showList(HttpServletRequest request){
		System.out.println("what happen");
		int id  = 2001;
		List<CarConnSchool> carConnSchools = carConnSchoolService.getCarConnSchoolsByUniversityId(id);
		request.setAttribute("carConnSchools", carConnSchools);
		return "/carSchoolList";
	}
	
	@RequestMapping(value="/carschool/{id}/detail")
	public String showDetail(@PathVariable("id") Integer id,HttpServletRequest request){
		String specialService = carConnSchoolService.getCarConnSchoolById(id).getCarSchool().getSpecialService();
		request.setAttribute("specialServices", specialService);
		request.setAttribute("carConnSchool", carConnSchoolService.getCarConnSchoolById(id));
		request.setAttribute("goodCarConnTags", carConnTagService.getGoodCarConnTagsByCarSchoolId(id));
		request.setAttribute("badCarConnTags", carConnTagService.getBadCarConnTagsByCarSchoolId(id));
		request.setAttribute("commentList", commentService.getCommentsByCarSchoolId(carConnSchoolService.getCarConnSchoolById(id).getCarSchool().getCarSchoolId()));
		return "/detail";
	}	
	
	
}
