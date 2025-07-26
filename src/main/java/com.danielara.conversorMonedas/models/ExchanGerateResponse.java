package com.danielara.conversorMonedas.models;

public record ExchanGerateResponse(
    String result,
    String base_code,
    String target_code,
    double conversion_rate,
    double conversion_result
)
{}
