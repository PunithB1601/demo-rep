package in.punith.dto;

import lombok.Data;

@Data
public class PaymentDto {

	private Integer paymentId; 
	
	private String razorPayPaymentId;
	
	private String razorPayOrderId;
	
	private Double amount;
	
	private String currency;
	

}
