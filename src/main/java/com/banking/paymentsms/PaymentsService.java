package com.banking.paymentsms;

import org.springframework.http.ResponseEntity;

public interface PaymentsService {
    public ResponseEntity<String> getCards() throws Exception;
    public ResponseEntity<String> addCards() throws Exception;
}
