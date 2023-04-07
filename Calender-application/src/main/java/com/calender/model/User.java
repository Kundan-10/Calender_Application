package com.calender.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	
	@Pattern(regexp = "^[a-zA-Z]*$", message = "First Name Special Characters are not Allowed.")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Last Name Special Characters are not Allowed.")
	private String lastName;
	 
	@Pattern(regexp = "[789]{1}[0-9]{9}",message = "invalid mobile number")	 
	private String mobileNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Past(message="date should be past")
	private LocalDate dateOfBirth;

}
