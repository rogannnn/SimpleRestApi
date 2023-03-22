package com.example.simplerestapi.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequest {

    @NotBlank(message = "Name must not be blank")
    private String name;
}
