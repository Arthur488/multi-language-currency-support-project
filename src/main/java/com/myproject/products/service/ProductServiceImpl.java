package com.myproject.products.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myproject.products.dao.ProductRepository;
import com.myproject.products.entity.Currency;
import com.myproject.products.entity.Product;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private static final String API_CURRENCY_URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List <Product> findAll() {
        return (List <Product>) productRepository.findAll();
    }

    @Override
    public Double[] getCurrencyCourseFromAPI() {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        Request request = new Request.Builder().url(API_CURRENCY_URL).build();

        try (Response response = client.newCall(request).execute()) {
            String responseData = response.body().string();
            Type productListType = new TypeToken <List<Currency>>() {}.getType();

            List<Currency> currencyList = gson.fromJson(responseData, productListType);
            Double saleUSD = currencyList.get(1).getSale();
            Double saleEUR = currencyList.get(0).getSale();

            return new Double[] {saleUSD, saleEUR};
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
