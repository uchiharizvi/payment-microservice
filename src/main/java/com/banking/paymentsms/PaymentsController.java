package com.banking.paymentsms;

import com.banking.paymentsms.aspects.RestLog;
import com.banking.paymentsms.aspects.RestLogAspect;
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
    @Autowired
    RestLogAspect restLogAspect;

    public PaymentsController(PaymentsService paymentsService, RestLogAspect restLogAspect) {
        this.paymentsService = paymentsService;
        this.restLogAspect = restLogAspect;
    }

    @RestLog(apiName = "getCards")
    @GetMapping("/cards")
    public ResponseEntity<String> getCards() throws Exception {
        return paymentsService.getCards();
    }
    @RestLog(apiName = "addCards")
    @PostMapping("/cards/add")
    public ResponseEntity<String> addCards() throws Exception {
        return paymentsService.addCards();
    }
}
