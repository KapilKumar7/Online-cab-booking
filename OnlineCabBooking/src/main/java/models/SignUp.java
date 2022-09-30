package com.cabBooking.models;



import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="users")
public class SignUp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;


	@NotNull
	@Pattern(regexp="[a-z]{3,12}", message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.")
	private String userName;

	@NotNull
	@Pattern(regexp="[a-zA-Z0-9]{6,18}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	private String password;

	@NotNull
	@Pattern(regexp="[0-9]{10}", message = "Mobile number must have 10 digits")
	private String mobileNo;

	@Email
	@NotNull
	private String email;
	
//	{
//
//		"userName":"kapilkumar",
//		"password":"Kapil123",
//		"mobileNo":9992382395,
//		"email":"kapil@gmail.com"
//		}

}
