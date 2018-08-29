package com.giannopoulos.spring5.rest.template.services;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;

    private final String apiUrl;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @Override
    public void testRestTemplate() {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl);

        // GET CUSTOMERS
        System.out.println("Get All Customers...");
        getAllCustomers(uriComponentsBuilder);

        // CREATE CUSTOMER
        System.out.println("Create Customer...");
        createCustomer(uriComponentsBuilder);

        // UPDATE CUSTOMER
        System.out.println("Update Customer...");
        updateCustomer(uriComponentsBuilder);

        // DELETE CUSTOMER
        System.out.println("Delete Customer...");
        deleteCustomer(uriComponentsBuilder);
    }

    private void deleteCustomer(UriComponentsBuilder uriComponentsBuilder) {

        //Java object to parse to JSON
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("firstname", "Les");
        postMap.put("lastname", "Claypool");

        JsonNode jsonNode = restTemplate.postForObject(uriComponentsBuilder.toUriString(), postMap, JsonNode.class);

        String customerUrl = jsonNode.get("customer_url").textValue();

        String id = customerUrl.split("/")[3];

        System.out.println("Created customer id: " + id);

        restTemplate.delete(uriComponentsBuilder.toUriString() + id); //expects 200 status

        System.out.println("Customer deleted");

        //should go boom on 404
        //restTemplate.getForObject(uriComponentsBuilder.toUriString() + id, JsonNode.class);
    }

    private void updateCustomer(UriComponentsBuilder uriComponentsBuilder) {

        //Java object to parse to JSON
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("firstname", "Micheal");
        postMap.put("lastname", "Weston");

        JsonNode jsonNode = restTemplate.postForObject(uriComponentsBuilder.toUriString(), postMap, JsonNode.class);

        String customerUrl = jsonNode.get("customer_url").textValue();

        String id = customerUrl.split("/")[3];

        System.out.println("Created customer id: " + id);

        postMap.put("firstname", "Micheal 2");
        postMap.put("lastname", "Weston 2");

        restTemplate.put(uriComponentsBuilder.toUriString() + id, postMap);

        JsonNode updatedNode = restTemplate.getForObject(uriComponentsBuilder.toUriString() + id, JsonNode.class);

        System.out.println(updatedNode.toString());
    }

    private void createCustomer(UriComponentsBuilder uriComponentsBuilder) {

        // Java object to parse to JSON
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("firstname", "Joe");
        postMap.put("lastname", "Buck");

        JsonNode response = restTemplate.postForObject(uriComponentsBuilder.toUriString(), postMap, JsonNode.class);
        System.out.println(response);
    }

    private void getAllCustomers(UriComponentsBuilder uriComponentsBuilder) {

        JsonNode response = restTemplate.getForObject(uriComponentsBuilder.toUriString(), JsonNode.class);
        System.out.println(response);
    }
}
