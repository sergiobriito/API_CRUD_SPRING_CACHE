package com.API_CRUD_USERS.dtos;


import com.API_CRUD_USERS.annotations.ListOfStrings;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {

    @NotBlank
    @Size(max = 32)
    private String username;

    @NotBlank
    @Pattern(regexp = "\\D+")
    @Size(max = 100)
    private String name;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    private String birthday;

    @ListOfStrings(value = 32)
    private List<String> stack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getStack() {
        return stack;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }
}
