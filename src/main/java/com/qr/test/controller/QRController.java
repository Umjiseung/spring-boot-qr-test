package com.qr.test.controller;

import com.qr.test.service.QRGenerateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qr")
public class QRController {

    private final QRGenerateService qrGenerateService;

    public ResponseEntity<byte[]> generateQR(@RequestParam String phone, String program) {
        byte[] result = qrGenerateService.execute(phone, program);
        return ResponseEntity.ok(result);
    }
}
