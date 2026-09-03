package in.punith.request;

import lombok.Data;

@Data
public class PaymentRequest {

	private Integer orderId;
	
	private Double amount;
}
