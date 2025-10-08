package com.longbow.plan_service.DTO;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlansDTO {

    @NotBlank(message = "Plan name is required")
    @Size(max = 64, message = "Plan name cannot exceed 64 characters")
    private String planName;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price must be zero or greater")
    private Integer price;

    @NotNull(message = "Duration cannot be null")
    @Min(value = 1, message = "Duration must be at least 1")
    private Integer duration;

    @NotNull(message = "isActive must not be null")
    private Boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

