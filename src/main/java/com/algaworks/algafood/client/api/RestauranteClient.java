package com.algaworks.algafood.client.api;

import com.algaworks.algafood.client.model.RestauranteResumoModel;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {

    private static final String RESOURCE_PATH = "/restaurantes";

    private final RestTemplate restTemplate;
    private final String url;

    public List<RestauranteResumoModel> listar() {
        URI resourceUri = URI.create(url + RESOURCE_PATH);

        RestauranteResumoModel[] restaurantes = restTemplate
                .getForObject(resourceUri, RestauranteResumoModel[].class);

        assert restaurantes != null;
        return Arrays.asList(restaurantes);
    }
}
