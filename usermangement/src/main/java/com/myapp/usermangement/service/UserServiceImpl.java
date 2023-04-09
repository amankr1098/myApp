package com.myapp.usermangement.service;

import com.myapp.common.commons.GetResponse;
import com.myapp.common.enums.UserType;
import com.myapp.common.requestPyload.LoginUser;
import com.myapp.common.requestPyload.RegisterUser;
import com.myapp.common.responseDto.ApiResponse;
import com.myapp.db.entity.User;
import com.myapp.db.services.user.UserDbService;
import com.myapp.usermangement.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDbService userDbService;
    private final UserMapper userMapper;
    private final GetResponse getResponse;

    @Override
    public ApiResponse registerUser(RegisterUser registerUser) {
        ApiResponse response;
        try {
            User existingUser = userDbService.fetchByUsername(registerUser.getUsername());
            if (existingUser != null) {
                return getResponse.getErrorResponse(HttpStatus.BAD_REQUEST, "", "Username already exist");
            }
            existingUser = userDbService.fetchByEmail(registerUser.getEmail());
            if (existingUser != null) {
                return getResponse.getErrorResponse(HttpStatus.BAD_REQUEST, "", "Email already exist");
            }
            User user = userMapper.map(registerUser);
            user.setUserType(UserType.USER.name());
            userDbService.save(user);
            response = getResponse.getSuccessfulResponse(HttpStatus.CREATED, user, "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public ApiResponse loginUser(LoginUser loginUser) {
        User existingUser = userDbService.fetchByUsername(loginUser.getUsername());
        if(existingUser==null){
            existingUser = userDbService.fetchByEmail(loginUser.getUsername());
            if(existingUser == null){
                return getResponse.getErrorResponse(HttpStatus.BAD_REQUEST,"","No username/email exist!");
            }
        }
        if(!Objects.equals(existingUser.getPassword(), loginUser.getPassword())){
            return getResponse.getErrorResponse(HttpStatus.FORBIDDEN,"","Invalid Password!");
        }
        return getResponse.getSuccessfulResponse(HttpStatus.ACCEPTED,"Login Successful","");
    }
}
