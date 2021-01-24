package com.password.service.impl;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.password.model.IsValid;
import com.password.model.Password;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordValidateServiceImplTest {
	

	@Autowired
	PasswordValidateServiceImpl passwordValidateServiceImpl;
	
	
	
	@Test
	@DisplayName("Teste isValid True")
	public void whenIsValidTrue() {
		IsValid isValid = passwordValidateServiceImpl.isValid(getPassword("AbTp9!fok"));		
		Assertions.assertEquals(isValid.getIsValid(), getReturnTrue().getIsValid());
	}	
	
	@Test
	@DisplayName("Teste isValid false At least 1 digit")
	public void whenIsValIsFalseAtDigit() {
		IsValid isValid = passwordValidateServiceImpl.isValid(getPassword("AbTpC!fok"));		
		Assertions.assertEquals(isValid.getIsValid(), getReturnFalse().getIsValid());
	}
	
	@Test
	@DisplayName("Teste isValid false At least 1 lowerCase")
	public void whenIsValidIsFalseAtLowerCase() {
		IsValid isValid = passwordValidateServiceImpl.isValid(getPassword("ABTP9!FOK"));		
		Assertions.assertEquals(isValid.getIsValid(), getReturnFalse().getIsValid());
	}
	
	@Test
	@DisplayName("Teste isValid false At least 1 upperCase")
	public void whenIsValidIsFalseAtUpperCase() {
		IsValid isValid = passwordValidateServiceImpl.isValid(getPassword("abtp9!fo"));		
		Assertions.assertEquals(isValid.getIsValid(), getReturnFalse().getIsValid());
	}
	
	@Test
	@DisplayName("Teste isValid false At least 1 specialChar")
	public void whenIsValidIsFalseAtSpecialChar() {
		IsValid isValid = passwordValidateServiceImpl.isValid(getPassword("abtp90Afo"));		
		Assertions.assertEquals(isValid.getIsValid(), getReturnFalse().getIsValid());
	}
	
	@Test
	@DisplayName("Teste isValid false At repeat char")
	public void whenIsValidIsFalseAtRepeatChar() {
		IsValid isValid = passwordValidateServiceImpl.isValid(getPassword("abtp90+Afoo"));		
		Assertions.assertEquals(isValid.getIsValid(), getReturnFalse().getIsValid());
	}
	
	@Test
	@DisplayName("Teste isValid false At space char")
	public void whenIsValidIsFalseAtSpaceChar() {
		IsValid isValid = passwordValidateServiceImpl.isValid(getPassword("abtp90+Afo "));		
		Assertions.assertEquals(isValid.getIsValid(), getReturnFalse().getIsValid());
	}
	
	@Test
	@DisplayName("Teste isValid false At less then nine")
	public void whenIsValidIsFalseAtLessThenNine() {
		IsValid isValid = passwordValidateServiceImpl.isValid(getPassword("AbTp9!fo"));		
		Assertions.assertEquals(isValid.getIsValid(), getReturnFalse().getIsValid());
	}

	
	private Password getPassword(String password) {
		Password p = new Password();
		p.setPassword(password);
		return p;
	}
	
	private IsValid getReturnTrue() {
		IsValid isValid = new IsValid();
		isValid.setIsValid(true);
		return isValid;
	}
	
	private IsValid getReturnFalse() {
		IsValid isValid = new IsValid();
		isValid.setIsValid(false);
		return isValid;
	}


}
