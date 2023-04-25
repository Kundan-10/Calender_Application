package com.celender.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	@Email(message="correct the mail")
	private String mail;
	
	private String firstName;
	
	private String lastName;
	
	@Size(min = 10,max = 10 ,message = "mobile number should be 10 digit")
	private String mobileNumber;
	
	private String password;
	@Past(message="date should be past")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate birthDate;

}
