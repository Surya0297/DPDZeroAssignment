package com.DPDZero.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(unique = true) 
    @NotBlank(message = "Username is required")
    private String username;
    
    @NotNull
    @Column(unique = true)
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;
    
    @NotNull
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain a mix of uppercase, lowercase, digits, and special characters")
    private String password;
    
    @NotNull
    @NotBlank(message = "Full name is required")
    private String fullName;
    
    @NotNull
    @NotBlank(message = "Age is required")
    private int age;
    
    @NotNull
    @NotBlank(message = "Gender is required")
    private String gender;

    
}

