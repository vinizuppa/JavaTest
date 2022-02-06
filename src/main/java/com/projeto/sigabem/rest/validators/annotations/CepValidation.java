package com.projeto.sigabem.rest.validators.annotations;

import com.projeto.sigabem.rest.validators.CepValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//@Target({ElementType.TYPE})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CepValidator.class)
@Documented
public @interface CepValidation {

    String message() default "Cep inválido";

    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};

}
