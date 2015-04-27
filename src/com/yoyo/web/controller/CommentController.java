package com.yoyo.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoyo.domain.CarConnTag;
import com.yoyo.domain.CarSchool;
import com.yoyo.domain.Comment;
import com.yoyo.domain.MainUser;
import com.yoyo.service.CarConnTagService;
import com.yoyo.service.CarSchoolService;
import com.yoyo.service.CommentService;
import com.yoyo.service.MainUserService;
import com.yoyo.web.exception.ParameterException;
@Controller
public class CommentController extends BaseController{
	@Autowired
	CommentService commentService;
	@Autowired
	CarSchoolService carSchoolService;
	@Autowired
	MainUserService mainUserService;
	
	@Autowired
	CarConnTagService carConnTagService;
	
	@ResponseBody
	@RequestMapping(value="/comment/{id}/list",method=RequestMethod.GET)
	public List<CommentCommand> getCommentsByCarSchoolIdInPage(
			@PathVariable("id")Integer id,@RequestParam(value="pageNo",required=true)Integer pageNo){
		System.out.println(commentService.getCommentsByCarSchoolIdInPage(pageNo, id));
		List<Comment> commentList =  commentService.getCommentsByCarSchoolIdInPage(pageNo, id);
		List<CommentCommand> commentCommands = new ArrayList<CommentCommand>();
		for(Comment comment : commentList){
			CommentCommand tempComment = new CommentCommand(comment.getCarCommentId(),
					comment.getCarCommentContent(), comment.getMainUser().getUsername(),comment.getMainUser().getUserimage(),comment.getCommentDate());
			commentCommands.add(tempComment);
		}
		return commentCommands;
	}
	
	@ResponseBody
	@RequestMapping(value="/carschool/{id}/commentSub",method=RequestMethod.GET)
	public OrderString submitComment(@PathVariable("id")Integer id,
			@RequestParam(value="carSchoolName",required=true)String carSchoolName,
			@RequestParam(value="enviroment",required=true)String enviroment,
			@RequestParam(value="subscript",required=true)String subsript,
			@RequestParam(value="coach",required=true)String coach,
			@RequestParam(value="comment",required=true)String comment,
			@RequestParam(value="commentTimestamp",required=true)String commentTimestamp){
		CarSchool carSchool = carSchoolService.getCarSchoolByName(carSchoolName);
		MainUser mainUser = mainUserService.getMainUserById(id);
		Comment commentSub = new Comment(comment, mainUser, carSchool, commentTimestamp);
		
		commentService.addComment(commentSub);
		//环境标签
		CarConnTag oldConn = carConnTagService.getCarConnTagByTagSchool(enviroment, carSchoolService.getCarSchoolId(carSchool));
		int newNum = carConnTagService.getCarConnTagNum(oldConn)+1;
		CarConnTag newConn = carConnTagService.setCarConnTagNum(oldConn, newNum);
		carConnTagService.updateCarConnTag(newConn);
		//预约标签
		oldConn = carConnTagService.getCarConnTagByTagSchool(subsript, carSchoolService.getCarSchoolId(carSchool));
		newNum = carConnTagService.getCarConnTagNum(oldConn)+1;
		newConn = carConnTagService.setCarConnTagNum(oldConn, newNum);
		carConnTagService.updateCarConnTag(newConn);
		//教练标签
		oldConn = carConnTagService.getCarConnTagByTagSchool(coach, carSchoolService.getCarSchoolId(carSchool));
		newNum = carConnTagService.getCarConnTagNum(oldConn)+1;
		newConn = carConnTagService.setCarConnTagNum(oldConn, newNum);
		carConnTagService.updateCarConnTag(newConn);
		
		OrderString orderString = new OrderString("OK");
		return orderString;
	}
	
	@RequestMapping(value="/comment/ex",method=RequestMethod.GET)
	public void ex() throws ParameterException{
		throw new ParameterException();
	}
}

