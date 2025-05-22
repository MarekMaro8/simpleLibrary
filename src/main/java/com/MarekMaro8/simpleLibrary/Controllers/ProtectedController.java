package com.MarekMaro8.simpleLibrary.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/protected")
public class ProtectedController {

    @GetMapping
    public String getProtectedData() {
        return "To są chronione dane!";
    }
}