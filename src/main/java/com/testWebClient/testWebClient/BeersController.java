package com.testWebClient.testWebClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/api/v1/beer")
public class BeersController {
	@Autowired
	private TripleDESService tripleDESService;
	@Autowired
	private ModelBeers modelBeers;
	
	@GetMapping("/randon")
	public Mono<ModelBeers> getRandon() throws Exception{
		String URL = "https://random-data-api.com";
		String ENDPOINT = "/api/v2/beers";
		WebClient webClient = WebClient.builder().baseUrl(URL).build();
		Mono<ModelBeers> response = webClient.get().uri(ENDPOINT).retrieve().bodyToMono(ModelBeers.class);
		//((Object) modelBeers).setEncritp(tripleDESService.encrypt("vladimir"));
		
		System.out.println(tripleDESService.encrypt("vladimir"));
		return response;
		
	}

}
//http://localhost:8080/api/v1/beer/randon