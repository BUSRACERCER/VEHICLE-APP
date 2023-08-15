package com.works.configs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rest {
    //@AllArgsConstructor: İlgili class’ın constructor’ını üretir. Bu constructor tüm field’ları parametre olarak alır.
   // birileri servisi dönderdiğinde status true yazı standartımız oluşması için yaptık private Boolean status;
    private Boolean status;
    private Object result;

}
