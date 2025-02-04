package academy.itk.task11.mapper;

import academy.itk.task11.model.User;
import academy.itk.task11.api.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orders", ignore = true)
    User mapToEntity(UserDto source);

    UserDto mapToDto(User source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orders", ignore = true)
    void update(@MappingTarget User target, UserDto source);
}
