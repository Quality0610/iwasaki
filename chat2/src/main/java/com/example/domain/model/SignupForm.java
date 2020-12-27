package com.example.domain.model;

import lombok.Data;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Data
public class SignupForm {

	@NotBlank
	@Length(min=6)
	private String userName;
	
	@NotBlank
	@Length(min=6)
	private String password;
	
	@NotBlank
	@Length(min=6)
	private String confirmationPassword;
	
}
