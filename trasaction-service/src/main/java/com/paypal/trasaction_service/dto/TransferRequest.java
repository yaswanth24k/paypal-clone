package com.paypal.trasaction_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransferRequest {
    private Long senderId;
    private Long receiverId;
    private Double amount;

}
