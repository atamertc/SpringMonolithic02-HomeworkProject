package com.atamertc.mapper;

import com.atamertc.dto.request.CategorySaveRequestDto;
import com.atamertc.dto.response.CategoryFindAllResponseDto;
import com.atamertc.repository.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryMapper {
    ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);

    CategoryFindAllResponseDto fromUser(final Category categories);
    Category saveFromRequestsDto(final CategorySaveRequestDto dto);
}
