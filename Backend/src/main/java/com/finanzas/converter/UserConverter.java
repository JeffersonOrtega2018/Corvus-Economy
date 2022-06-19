package com.finanzas.converter;

import com.finanzas.dto.SignupRequestDto;
import com.finanzas.dto.UserDto;
import com.finanzas.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private final ModelMapper modelMapper;

    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDto convertEntityToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User convertDtoToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public User signup(SignupRequestDto signupRequestDto){
        return modelMapper.map(signupRequestDto, User.class);
    }
}
