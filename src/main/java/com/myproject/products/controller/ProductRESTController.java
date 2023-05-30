package com.myproject.products.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRESTController {

    @PostMapping("/changeLanguage")
    public ResponseEntity <Void> changeLanguage(@RequestParam("language") String language, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("language", language);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/changeCurrency")
    public void changeCurrency(@RequestParam("currency") String currency, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (currency.equals("uah")) {
            session.setAttribute("currency", null);
        }
        else {
            String previousCurrencyValue = (String) session.getAttribute("currency");
            session.setAttribute("previousCurrencyValue", previousCurrencyValue);
            session.setAttribute("currency", currency);
        }
    }

}
