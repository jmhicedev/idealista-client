package com.higuera.apiidealista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.higuera.apiidealista.dto.AuthResponseDTO;
import com.higuera.apiidealista.dto.SearchResponseDTO;
import com.higuera.apiidealista.filters.GenericFilter;
import com.higuera.apiidealista.filters.model.OperationType;
import com.higuera.apiidealista.filters.model.PropertyTypeType;
import com.higuera.apiidealista.services.AuthServiceImpl;
import com.higuera.apiidealista.services.SearchServiceImpl;

@SpringBootApplication
public class ApiidealistaApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(ApiidealistaApplication.class, args);
		AuthServiceImpl authService = ctx.getBean(AuthServiceImpl.class);
		AuthResponseDTO authResponse = authService.authenticate();
		System.out.println(authResponse.toString());
		
		SearchServiceImpl searchService = ctx.getBean(SearchServiceImpl.class);
		GenericFilter filter = new GenericFilter(authResponse);
		filter.setLocationId("0-EU-ES-28");
		filter.setPropertyType(PropertyTypeType.HOMES);
		filter.setOperation(OperationType.RENT);
		SearchResponseDTO searchResponse = searchService.search(filter);
		searchResponse.toString();
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
