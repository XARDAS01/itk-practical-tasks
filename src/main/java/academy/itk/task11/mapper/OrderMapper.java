package academy.itk.task11.mapper;

import academy.itk.task11.model.Order;
import academy.itk.task11.api.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto mapToDto(Order source);

    @Mapping(target = "id", ignore = true)
    Order mapToEntity(OrderDto source);
}
