package co.edu.lasalle.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder)
  {
    return restTemplateBuilder
      .setConnectTimeout((int)30e3)
      .setReadTimeout((int)30e3)
      .build();
  }
}
