package org.fastcampus.auth.application.Interfaces;

import org.fastcampus.auth.domain.Email;

public interface EmailSendRepository {
    void sendEmail(Email email, String randomToken);
}
