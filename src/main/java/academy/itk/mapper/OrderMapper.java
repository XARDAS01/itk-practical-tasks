package academy.itk.mapper;

import academy.itk.model.Order;
import academy.itk.api.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto mapToDto(Order source);

    @Mapping(target = "id", ignore = true)
    Order mapToEntity(OrderDto source);
}
