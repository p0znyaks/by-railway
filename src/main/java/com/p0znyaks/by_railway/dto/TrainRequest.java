package com.p0znyaks.by_railway.dto;

import com.p0znyaks.by_railway.entity.enums.TrainType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TrainRequest(@NotBlank @Size(max = 50) String number, @NotNull TrainType type) {}
