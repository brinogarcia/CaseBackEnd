package com.password.service.impl;

import org.springframework.stereotype.Service;

import com.password.model.IsValid;
import com.password.model.Password;
import com.password.service.PasswordValidateService;

@Service
public class PasswordValidateServiceImpl implements PasswordValidateService{

	@Override
	public IsValid isValid(Password password) {
		IsValid isValid = new IsValid();
		isValid.setIsValid(false);
		if (!space(password.getPassword())) {
			if (countSizePassword(password.getPassword()) >= 9) {
				if (countDigit(password.getPassword())) {
					if (upperChar(password.getPassword())) {
						if (lowerChar(password.getPassword())) {
							if (specialChars(password.getPassword())) {
								if (distinctChars(password.getPassword()))
									isValid.setIsValid(true);
							}

						}
					}
				}
			}
		}

		return isValid;
	}

	private boolean space(String password) {
		int space = password.indexOf(' ');

		if (space >= 0) {
			System.out.println(" caracter invalido! ");
			return true;
		}
		return false;
	}

	private int countSizePassword(String password) {
		return password.length();
	}

	private boolean countDigit(String password) {
		for (char c : password.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	private boolean upperChar(String password) {
		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	private boolean lowerChar(String password) {
		for (char c : password.toCharArray()) {
			if (Character.isLowerCase(c)) {
				return true;
			}
		}
		return false;
	}

	private boolean specialChars(String password) {
		String specialChars = "!@#$%^&*()-+";
		for (char c : password.toCharArray()) {
			if (specialChars.contains(String.valueOf(c))) {
				return true;
			}
		}
		return false;
	}

	private boolean distinctChars(String password) {
		StringBuilder sb = new StringBuilder();
		password.chars().distinct().forEach(c -> sb.append((char) c));
		if (sb.length() == password.length()) {
			return true;
		}

		return false;
	}

}
