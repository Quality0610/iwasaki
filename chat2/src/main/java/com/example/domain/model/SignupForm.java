package com.example.domain.model;

import lombok.Data;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Data
public class SignupForm {

	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 6, groups = ValidGroup2.class)
	private String userName;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 6, groups = ValidGroup2.class)
	private String password;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 6, groups = ValidGroup2.class)
	private String confirmationPassword;
	
}
