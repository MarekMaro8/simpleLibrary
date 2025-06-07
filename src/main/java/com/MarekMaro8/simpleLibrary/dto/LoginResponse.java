package com.MarekMaro8.simpleLibrary.controllers;

public class LoginResponse{
        private String token;

        // ✅ Konstruktor
     public LoginResponse(String token) {
            this.token = token;
        }

        // ✅ Getter
        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
}
