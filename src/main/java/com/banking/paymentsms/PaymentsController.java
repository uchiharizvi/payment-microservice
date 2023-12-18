package com.banking.paymentsms;

import com.banking.paymentsms.aspects.LogResponseTime;
import com.banking.paymentsms.aspects.LogResponseTimeAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class PaymentsController {
    private static final Logger log = LoggerFactory.getLogger(PaymentsController.class);
    @Autowired
    PaymentsService paymentsService;
    @Autowired
    LogResponseTimeAspect logResponseTimeAspect;

    public PaymentsController(PaymentsService paymentsService, LogResponseTimeAspect logResponseTimeAspect) {
        this.paymentsService = paymentsService;
        this.logResponseTimeAspect = logResponseTimeAspect;
    }

    @LogResponseTime(apiName = "getCards")
    @GetMapping("/cards")
    public ResponseEntity<String> getCards() throws Exception {
        return paymentsService.getCards();
    }
    @LogResponseTime(apiName = "addCards")
    @PostMapping("/cards/add")
    public ResponseEntity<String> addCards(@RequestBody String payload) throws Exception {
        return paymentsService.addCards(payload);
    }
}
