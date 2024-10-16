package com.qr.test.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QRGenerateService {

    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;

    public byte[] execute(String phone, String program) {
        try {
            String information = "{\"phone\":" + phone + ", \"" + program+ "\": }";

            BitMatrix encode = new MultiFormatWriter().encode(information, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            MatrixToImageWriter.writeToStream(encode, "PNG", out);

            return out.toByteArray();
        } catch (WriterException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
