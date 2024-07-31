package org.choongang.member.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.global.validators.MobileValidator;
import org.choongang.global.validators.PasswordValidator;
import org.choongang.member.repository.MemberRepository;
import org.choongang.member.controllers.RequestJoin;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator, PasswordValidator , MobileValidator {
    private final MemberRepository memberRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }
        RequestJoin form = (RequestJoin) target;
        String email = form.getEmail();
        String password = form.getPassword();
        String mobile = form.getMobile();
        String confirmPassword = form.getConfirmPassword();
        if(memberRepository.exist(email)){
            errors.rejectValue("email","Duplicated");
        }

        if(!password.equals(confirmPassword)) {
            errors.rejectValue("confirmPassword", "Mismatch.password");
        }
        if(!alphaCheck(password,false) || !numberCheck(password) || !specialCharsCheck(password)){
            errors.rejectValue("password", "Complexity");
        }

        if(!mobilecheck(mobile)){
            errors.rejectValue("mobile", "Mobile");
        }
    }
}
