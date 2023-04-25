package com.calender.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
	
	@Id
	@Email(message="please check mail")
	private String mail;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userName;
	
	@Pattern(regexp = "^[a-zA-Z]$", message = "No Special Characters Allowed.")
	private String firstName;
	
	@Size(min = 10,max = 10 ,message = "mobile number should be 10 digit")
	private String mobileNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Past(message="date should be past")
	private LocalDate birthDate;
	
	@Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])).{6,100}$", message = "password not allowed")
	private String password;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Event> events=new ArrayList<>();

}
