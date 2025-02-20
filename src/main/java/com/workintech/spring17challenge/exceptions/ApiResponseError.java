package com.workintech.spring17challenge.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponseError {
    private int status;      //HTTP status değeri
    private String message;  //Hata fırlatıldığında hata için yazılacak mesaj
    private long timeStamp;//Hatanın fırlatıldığı zaman anı
}
