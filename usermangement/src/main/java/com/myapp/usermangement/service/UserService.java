package com.myapp.usermangement.service;

import com.myapp.common.requestPyload.LoginUser;
import com.myapp.common.requestPyload.RegisterUser;
import com.myapp.common.responseDto.ApiResponse;
import org.springframework.stereotype.Component;

public interface UserService {

    ApiResponse registerUser(RegisterUser registerUser);

    ApiResponse loginUser(LoginUser loginUser);
}
