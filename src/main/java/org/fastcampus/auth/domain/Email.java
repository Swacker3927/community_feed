package org.fastcampus.auth.domain;

import java.util.regex.Pattern;

public class Email {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    private final String emailText;

    private Email(String email) {
        this.emailText = email;
    }

    public String getEmailText() {
        return this.emailText;
    }

    public static Email createEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email is not valid");
        }
        if (!isValidEmailString(email)) {
            throw new IllegalArgumentException("email is not valid");
        }

        return new Email(email);
    }

    private static boolean isValidEmailString(String email) {
        return pattern.matcher(email).matches();
    }
}
