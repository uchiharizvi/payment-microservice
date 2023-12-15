package com.banking.paymentsms;

import com.banking.paymentsms.aspects.RestLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentsServiceImpl implements PaymentsService {
    private static final Logger log = LoggerFactory.getLogger(PaymentsServiceImpl.class);
    @Override
    public ResponseEntity<String> getCards() throws Exception {
        return new ResponseEntity<>("Cards Fetched Successfully", HttpStatus.OK);
    }

    @Override
    @RestLog
    public ResponseEntity<String> addCards() throws Exception {
        return new ResponseEntity<>("Cards Added Successfully", HttpStatus.CREATED);
    }
}
