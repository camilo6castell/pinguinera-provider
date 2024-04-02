package com.pinguinera.provider.controllers;

import com.pinguinera.provider.models.DTOS.RetailSaleDTO;
import com.pinguinera.provider.models.DTOS.WholeSaleDTO;
import com.pinguinera.provider.services.QuoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }
    @PostMapping("/CalculateRetailSaleQuote")
    public ResponseEntity<?> calculateRetailSaleQuote(@Valid @RequestBody RetailSaleDTO payload, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(quoteService.calculateRetailSaleQuote(payload));
        }
    }
    @PostMapping("/CalculateWholesaleQuote")
    public ResponseEntity<?> calculateWholesaleQuote(@Valid @RequestBody WholeSaleDTO payload, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(quoteService.calculateWholesaleQuote(payload));
        }
    }
}