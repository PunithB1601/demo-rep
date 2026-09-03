package in.punith.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.punith.dto.PaymentDto;
import in.punith.request.PaymentRequest;
import in.punith.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService pservice;

	@PostMapping("/request")
	public ResponseEntity<?> createPayment(@RequestBody PaymentRequest request){
		PaymentDto dto=pservice.createPayment(request);
		return ResponseEntity.ok(dto);
	}
}
