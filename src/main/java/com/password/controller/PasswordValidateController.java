package com.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.password.model.IsValid;
import com.password.model.Password;
import com.password.service.PasswordValidateService;

@RestController
public class PasswordValidateController {

	@Autowired
	PasswordValidateService passwordValidateService;

	@PostMapping("/password/isValid")
	public ResponseEntity<IsValid> createMovie(@RequestBody Password password) {
		IsValid isValid = passwordValidateService.isValid(password);

		return ResponseEntity.ok(isValid);
	}

}
