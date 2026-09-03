package in.punith.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import in.punith.dto.PaymentDto;
import in.punith.entity.Payment;
import in.punith.repo.PaymentRepo;
import in.punith.request.PaymentRequest;
import lombok.SneakyThrows;

@Service
public class PaymentService {
	
	@Autowired
	private RazorpayClient client;
	
	@Value("${razorpay.key.id}")
	private String razorPaykey;
	
	@Value("${razorpay.key.secret}")
	private String razorPaySecret;
	
	@Autowired
	private PaymentRepo prepo;
	
	@SneakyThrows
	public PaymentDto createPayment(PaymentRequest request){
		
		Integer paise=(int) (request.getAmount()*100);
		
		Map<String, Object> payment=new HashMap<>();
		payment.put("amount", paise);
		payment.put("currency", "INR");
		payment.put("receipt", "ORDER_"+request.getOrderId());
		JSONObject jsonObject=new JSONObject(payment);
		
		Order razorpayOrder=client.orders.create(jsonObject);
		
		Payment createPayment=new Payment();
		createPayment.setOrderId(request.getOrderId());
		createPayment.setAmount(request.getAmount());
		createPayment.setCurrency("INR");
		createPayment.setRazorPayOrderId(razorpayOrder.get("id"));
		createPayment.setStatus("PENDING");
		createPayment=prepo.save(createPayment);
		
		PaymentDto dto=new PaymentDto();
		dto.setRazorPayOrderId(createPayment.getRazorPayOrderId());
		dto.setAmount(createPayment.getAmount());
		dto.setCurrency(createPayment.getCurrency());
		dto.setPaymentId(createPayment.getPaymentId());
		return dto;
	}
}
