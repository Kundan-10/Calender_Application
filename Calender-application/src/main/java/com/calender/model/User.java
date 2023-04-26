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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
    @Email(message="correct the mail")
	private String Email;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userName;
	
	
	
	@Pattern(regexp = "^[a-zA-Z]*$", message = "First Name Special Characters are not Allowed.")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Last Name Special Characters are not Allowed.")
	private String lastName;
	 
	@Pattern(regexp = "[789]{1}[0-9]{9}",message = "invalid mobile number")	 
	private String mobileNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Past(message="date should be past")
	private LocalDate dateOfBirth;
	
	private String password;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Event> events=new ArrayList<>();

}
