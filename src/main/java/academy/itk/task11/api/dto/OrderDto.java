package academy.itk.task11.api.dto;

import academy.itk.task11.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
public class OrderDto {

    private UUID id;

    @NotNull(message = "Order status cannot be null")
    private OrderStatus status;

    @NotNull(message = "Price cannot be null")
    private BigDecimal price;
}
