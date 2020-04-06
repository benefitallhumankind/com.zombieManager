package com.zombiegame.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zombiegame.springboot.service.RoomService;

@Controller
public class RoomController {
	@Autowired
	private final RoomService rService;
	
	public RoomController(RoomService rService) {
		this.rService = rService;
	}
	
	@RequestMapping("/room/list")
	public String viewRoomList(Model model) {
		model.addAttribute("rooms", rService.getAllRooms());
	}
	
}
