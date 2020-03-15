package com.zombiegame.springboot.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table
public class Member implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String email;
	
	@Column
	private String pw;
	
	@Column
	@CreationTimestamp
	private Date regDate;
	
	@Column
	@UpdateTimestamp
	private LocalDateTime updateDate;
}
