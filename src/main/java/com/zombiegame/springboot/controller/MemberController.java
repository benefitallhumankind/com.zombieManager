package com.zombiegame.springboot.controller;

import javax.servlet.http.HttpSession;

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
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String viewSignIn(Model model) {
		model.addAttribute("member", new Member());
		return "signin";
	}
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signIn(@ModelAttribute Member member, Model model, HttpSession session) {
		String url = "/signin?error=true";
		Member dbm = mService.getMemberByEmail(member.getEmail());
		if( dbm!=null && member.getPw().equals(dbm.getPw())) {
			session.setAttribute("account", dbm);
			url = "/";
		}
		return "redirect:"+url;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String viewSignUp(Model model) {
		model.addAttribute("member", new Member());
		return "signup";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String addMember(@ModelAttribute Member member, Model model) {
		mService.addMember(member);
		return "redirect:/signin";
	}
	@RequestMapping("/member/delete/{id}")
	public String deleteMember(@PathVariable Long id) {
		mService.deleteMember(id);
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signOut(HttpSession session) {
		session.invalidate();
		return "redirect:/signin";
	}
}
