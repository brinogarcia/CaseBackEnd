package com.password.service;

import org.springframework.stereotype.Service;

import com.password.model.IsValid;
import com.password.model.Password;

@Service
public interface PasswordValidateService {
	
	public IsValid isValid(Password password);
	
}
