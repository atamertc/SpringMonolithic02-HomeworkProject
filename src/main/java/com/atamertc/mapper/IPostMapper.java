package com.atamertc.mapper;

import com.atamertc.dto.request.PostSaveRequestDto;
import com.atamertc.dto.response.PostFindAllResponseDto;
import com.atamertc.repository.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPostMapper {
    IPostMapper INSTANCE = Mappers.getMapper(IPostMapper.class);
    PostFindAllResponseDto fromPost(final Post post);
    Post saveFromRequestsDto(final PostSaveRequestDto dto);

}
