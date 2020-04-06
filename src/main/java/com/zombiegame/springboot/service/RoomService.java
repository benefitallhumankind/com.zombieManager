package com.zombiegame.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zombiegame.springboot.domain.Room;
import com.zombiegame.springboot.repository.RoomRepository;

@Service
public class RoomService {	//인터페이스 생성안했음
	
	@Autowired
	private RoomRepository rRepository;
	
	public Room addRoom(Room room) {
		return rRepository.save(room);
	}
	public void deleteRoom(Long id) {
		rRepository.deleteById(id);
	}
	public List<Room> getAllRooms() {
		return rRepository.findAll();
	}
	
	public Room getRoomByEmail(String email) {
		return rRepository.findByEmail(email);
	}
	
}
