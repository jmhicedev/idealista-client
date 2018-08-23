package com.higuera.apiidealista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.higuera.apiidealista.dto.AuthResponseDTO;
import com.higuera.apiidealista.dto.SearchResponseDTO;
import com.higuera.apiidealista.filters.GenericFilter;
import com.higuera.apiidealista.filters.model.LocationIdType;
import com.higuera.apiidealista.filters.model.OperationType;
import com.higuera.apiidealista.filters.model.PropertyTypeType;
import com.higuera.apiidealista.filters.model.SinceDateType;

@SpringBootApplication
public class ApiidealistaApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(ApiidealistaApplication.class, args);
		IdealistaClient idealistaClient = ctx.getBean(IdealistaClient.class);
		idealistaClient.setApikey("");
		idealistaClient.setApikey("");
		AuthResponseDTO authResponse = idealistaClient.authenticate();
		System.out.println(authResponse.toString());
		
		GenericFilter filter = new GenericFilter(authResponse);
		filter.setLocationId(LocationIdType.MADRID_NORTE_SANSE);
		filter.setPropertyType(PropertyTypeType.HOMES);
		filter.setOperation(OperationType.RENT);
		filter.setSinceDate(SinceDateType.LAST_MONTH);
		filter.setMaxItems(50);
		SearchResponseDTO searchResponse = idealistaClient.search(filter);
		
		//Object to json
		ObjectMapper mapper = new ObjectMapper();
		String jsonresponse = mapper.writeValueAsString(searchResponse);
		System.out.println("----");
		System.out.println(jsonresponse);
		System.out.println("----");
		String jsonelement = mapper.writeValueAsString(searchResponse.getElementList().get(0));
		System.out.println(jsonelement);
		System.out.println("----");
		
		System.out.println(searchResponse.toString());
	}
	
//	@Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
