package org.choongang.global.validators;

public interface MobileValidator {
    default boolean mobilecheck(String mobile) {
        mobile = mobile.replaceAll("\\D", "");
        String pattern = "010\\d{4}\\d{4}$";
        return mobile.matches(pattern);
    }
}
