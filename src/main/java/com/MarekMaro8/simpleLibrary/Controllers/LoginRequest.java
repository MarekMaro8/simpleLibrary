package com.MarekMaro8.simpleLibrary.Controllers;

public class LoginRequest {
        private String username;
        private String password;

        // ✅ Konstruktory
        public LoginRequest() {}

        public LoginRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // ✅ Gettery i settery
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }