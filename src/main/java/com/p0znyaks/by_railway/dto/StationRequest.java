package com.p0znyaks.by_railway.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StationRequest(
        @NotBlank @Size(max = 50) String name, @NotBlank @Size(max = 50) String city) {}
