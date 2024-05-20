package com.myproject.products.controller;

import com.myproject.products.entity.Product;
import com.myproject.products.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("/products")
    public String listAllProducts(Model model) {
        List <Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "all_products_page";
    }

//    @GetMapping("/products2")
//    public String getWelcomePage(HttpServletRequest request, Model model) {
//        // Получаем выбранный язык из сессии
//        HttpSession session = request.getSession();
//        String language = (String) session.getAttribute("language");
//        System.out.println(language);
//        // Получаем локализованный текст из файла ресурсов на основе выбранного языка
//        String welcomeMessage = messageSource.getMessage("welcome.message", null, new Locale(language));
//        System.out.println(welcomeMessage);
//
//        model.addAttribute("welcomeMessage", welcomeMessage);
//        return "all_products_page";
//    }

}
