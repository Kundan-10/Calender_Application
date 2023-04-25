package com.calender.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUserSession {

	@Id
	private String mail;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
}
