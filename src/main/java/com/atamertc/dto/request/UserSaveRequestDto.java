package com.atamertc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveRequestDto {
    String first_name;
    String last_name;
    String email;
    String password;
}
