package com.myproject;

import com.myproject.products.service.IProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class streamFilter implements Filter {

    private final IProductService productService;

    public streamFilter(IProductService productService) {
        this.productService = productService;
    }

    Double [] currency = null;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        if (session != null) {

            String language = (String) session.getAttribute("language");
            servletRequest.setAttribute("language", language);

            String currencyValue = (String) session.getAttribute("currency");
            String previousCurrencyValue = (String) session.getAttribute("previousCurrencyValue");

            if (currencyValue != null) {
                if (!Objects.equals(currencyValue, previousCurrencyValue) || currency == null) {
                    currency = productService.getCurrencyCourseFromAPI();
                    session.setAttribute("previousCurrencyValue", currencyValue);
                }
                switch (currencyValue) {
                    case "usd" -> servletRequest.setAttribute("USD", currency[0]);
                    case "eur" -> servletRequest.setAttribute("EUR", currency[1]);
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
