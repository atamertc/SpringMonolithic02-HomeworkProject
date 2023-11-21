package com.atamertc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum EErrorType {

    KULLANICI_BULUNAMADI(1001, "Aradiginiz kullanici bulunammadi", NOT_FOUND),
    KAYNAK_BULUNAMADI(1002, "Kaynak bulunamadi", NOT_FOUND);
    private int code;
    private String message;
    private HttpStatus status;

    }
