package com.MarekMaro8.simpleLibrary.Controllers;

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
