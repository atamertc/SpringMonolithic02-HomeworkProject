package com.atamertc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {
    @Column(length = 50)
    String name;
    @Column(length = 50)
    String surname;
    @ElementCollection
    List<Long> favMovies;

    @ElementCollection
    List<Long> favGenres;

    @ElementCollection
    List<Long> comments;

}
