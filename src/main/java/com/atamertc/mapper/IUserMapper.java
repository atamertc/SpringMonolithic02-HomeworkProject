package com.atamertc.mapper;

import com.atamertc.dto.request.RegisterRequestDto;
import com.atamertc.dto.response.LoginResponseDto;
import com.atamertc.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    LoginResponseDto toLoginResponseDto(final User user);

    List<LoginResponseDto> toLoginResponseDtos(final List<User> userList);

    User toUser(RegisterRequestDto dto);




}
