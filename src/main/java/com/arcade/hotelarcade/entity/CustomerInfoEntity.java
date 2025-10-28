package com.arcade.hotelarcade.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class CustomerInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 80, message = "The name can not be more than 80 characters")
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Size(max = 80, message = "The name can not be more than 80 characters")
    @NotBlank
    private String lastName;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Pattern(regexp = "\\d{10}|\\d{12}", message = "National ID must be 10 or 12 digits")
    private String nationalId;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Email(message = "Invalid email format")
    @Size(max = 100, min = 20)
    private String email;

    @Min(0)
    @Max(120)
    @Column(nullable = false)
    @NotBlank(message = "This field can not be blank")
    private Integer age;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 250)
    private String address;

    @Size(max = 50)
    private String city;
    @Size(max = 50)
    private String state;
    @Size(max = 50)
    private String country;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank
    @Size(max = 50)
    private String phone;

}
