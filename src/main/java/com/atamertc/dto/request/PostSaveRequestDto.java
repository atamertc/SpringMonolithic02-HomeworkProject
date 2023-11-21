package com.atamertc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//Kaydederken kullanıcıdan alınacak bilgileri içeren DTO
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostSaveRequestDto {
    //neredeyse tüm bilgiler bana gerekli geldi sadece id yi almadım
    String title;
    String content;
    LocalDate published_at;
    Long userid;
    Long categoryid;
}
