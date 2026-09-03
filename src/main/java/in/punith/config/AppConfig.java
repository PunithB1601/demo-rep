package in.punith.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.razorpay.RazorpayClient;

import lombok.SneakyThrows;

@Configuration
public class AppConfig {

	@Value("${razorpay.key.id}")
	private String razorPaykey;
	
	@Value("${razorpay.key.secret}")
	private String razorPaySecret;
	
	
	@SneakyThrows
	@Bean
	public RazorpayClient rpClient() {
		return new RazorpayClient(razorPaykey, razorPaySecret);
	}
	
}
