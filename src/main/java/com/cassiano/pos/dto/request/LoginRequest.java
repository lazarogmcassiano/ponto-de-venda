package com.cassiano.pos.dto.request;

public record LoginRequest(

        String barcode,

        String password

) {
}
