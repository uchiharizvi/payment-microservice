package com.banking.paymentsms;

import com.banking.paymentsms.aspects.RestLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentsController {
    private static final Logger log = LoggerFactory.getLogger(PaymentsController.class);
    @Autowired
    PaymentsService paymentsService;
    @RestLog
    @GetMapping("/cards")
    public ResponseEntity<String> getCards() throws Exception {
        return paymentsService.getCards();
    }
    @PostMapping("/cards/add")
    public ResponseEntity<String> addCards() throws Exception {
        return paymentsService.addCards();
    }
}
