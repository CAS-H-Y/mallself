package com.heyang.mall.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * creat on 2019/4/9
 * <p>
 * #author : CAS_hy
 **/
public class AdminValidatorClass implements ConstraintValidator<AdminValidator, String> {
   private String[] values;
   @Override
   public void initialize(AdminValidator constraint) {this.values=constraint.value();
   }
   @Override
   public boolean isValid(String obj, ConstraintValidatorContext context) {
      boolean isValid=true;
      if(!obj.equals("user")){
        return isValid;
      }
      return false;
   }
}
