package com.example.complexeSportif.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@Builder
@Getter
@Setter
public class RegisterRequest {
    @NotEmpty(message = "Firstname is mandatory")
    @NotBlank(message = "Firstname is mandatory")
    private String firstname;
    @NotEmpty(message = "Lastname is mandatory")
    @NotBlank(message = "Lastname is mandatory")
    private String lastname;
    @Email(message = "Not a valid format !")
    @NotEmpty(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotEmpty(message = "Fill the password space !")
    @NotBlank(message = "Fill the password space")
    @Size(min = 5, message = "Password should be at least 5 characters !")
    private String password;
    @NotEmpty(message = "Role is mandatory")
    @NotBlank(message = "Role is mandatory")
    private String role;


}
