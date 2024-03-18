package com.example.es14.Controllers;

import com.example.es14.Interceptors.MonthInterceptor;
import com.example.es14.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/months")
public class MonthController {
    @Autowired
    MonthInterceptor monthInterceptor;

    @GetMapping("/m")
    public Month getMonth(HttpServletRequest request) {
        return (Month) request.getAttribute("month");
    }
}
