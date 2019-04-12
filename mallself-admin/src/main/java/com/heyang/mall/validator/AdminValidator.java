package com.heyang.mall.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = AdminValidatorClass.class)
public @interface  AdminValidator {
    String[] value() default {};

    String message() default "admin username not user";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
