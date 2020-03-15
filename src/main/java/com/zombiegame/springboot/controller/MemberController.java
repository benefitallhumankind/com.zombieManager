package com.zombiegame.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zombiegame.springboot.domain.Member;
import com.zombiegame.springboot.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private final MemberService mService;
	
	public MemberController(MemberService mService) {
		this.mService = mService;
	}
	@RequestMapping("/member/list")
	public String viewMemberList(Model model) {
		model.addAttribute("members", mService.getAllMembers());
		return "memberList";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewlogin() {
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegister(Model model) {
		model.addAttribute("member", new Member());
		return "register";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addMember(@ModelAttribute Member member, Model model) {
		mService.addMember(member);
		return "redirect:member/list";
	}
	@RequestMapping("/member/delete/{id}")
	public String deleteMember(@PathVariable Long id) {
		mService.deleteMember(id);
		return "redirect:/member/list";
	}
}
