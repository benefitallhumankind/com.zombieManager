package com.zombiegame.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zombiegame.springboot.domain.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	Room findByEmail(String email);
}
