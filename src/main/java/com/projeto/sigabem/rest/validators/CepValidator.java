package com.projeto.sigabem.rest.validators;

import com.projeto.sigabem.rest.validators.annotations.CepValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CepValidator implements ConstraintValidator<CepValidation, String> {

    @Override
    public void initialize(CepValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cep, ConstraintValidatorContext constraintValidatorContext) {

        Matcher matcher;
        Pattern pattern;

        if(cep == null){
            return false;
        }

        if (cep.length() == 8) {
            pattern = Pattern.compile("[0-9]{8}");

        } else {
            pattern = Pattern.compile("[0-9]{5}-[0-9]{3}");
        }

        matcher = pattern.matcher(cep);//Confere se o CEP está de acordo com o pattern
        return matcher.matches();//retorna true ou false
    }
}
