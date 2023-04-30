package com.example.panaderiaelcoste.model;

import com.example.panaderiaelcoste.enums.AdminCredentials;
import lombok.Getter;


public class Admin {


      public static LoginCredential loginCredentials = new LoginCredential(AdminCredentials.USERNAME.getValue(), AdminCredentials.PASSWORD.getValue());
}
