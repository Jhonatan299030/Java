package br.com.lorde.supremo.loja.service;

import br.com.lorde.supremo.loja.controller.dto.InfoFornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    @Autowired
    private RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void getRequestObject(String url, Class classObject){
        ResponseEntity<InfoFornecedorDto> response = restTemplate.exchange(url, HttpMethod.GET,
            null, classObject
        );

        System.out.println(response.getBody().getEndereco());
    }
}