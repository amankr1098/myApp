package com.myapp.usermangement.mapper;

import com.myapp.common.requestPyload.RegisterUser;
import com.myapp.db.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(RegisterUser registerUser);
}
