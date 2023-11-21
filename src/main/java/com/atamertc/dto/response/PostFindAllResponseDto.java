package com.atamertc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostFindAllResponseDto {
    String title;
    String content;
    LocalDate published_at;
    Long userid;
    Long categoryid;
}
