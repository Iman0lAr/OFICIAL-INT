
package com.example.demo.Controladores;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {
    
    private final String API_URL = "https://api.apis.net.pe/v2/reniec/dni?numero=";
    private final String TOKEN = "apis-token-9701.8OJBTewDxyGdOcNhXtmVaBI3yy4Wy5VT";

    @GetMapping("/api/dni")
    public ResponseEntity<String> obtenerDni(@RequestParam String numero) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + TOKEN);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = API_URL + numero;


        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response;
    }
}
