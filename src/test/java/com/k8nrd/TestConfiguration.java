package com.k8nrd;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Profile("test")
@Configuration
public class TestConfiguration {
	
/*	@Bean
	public TabRepository tabRepositoryMock(){
		return mock(TabRepository.class);
	}
	
	@Bean
	public VerifyRepository verifyRepositoryMock(){
		return mock(VerifyRepository.class);
	}
	
	@Bean
	public MainSender mailSenderMock(){
		return mock(MainSender.class);
	}
	*/
	

}
