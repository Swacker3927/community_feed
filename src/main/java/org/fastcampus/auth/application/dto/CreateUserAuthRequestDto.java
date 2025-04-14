package org.fastcampus.auth.application.dto;

public record CreateUserAuthRequestDto(String email, String password, String name, String role, String profileUrl) {

}
