package com.example.testmapstruct.convert;

import com.example.testmapstruct.dto.EmployeeWorkDto;
import com.example.testmapstruct.po.EmployeeWorkPo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author lichangkai
 * @date 2020-09-06
 */
@Mapper(componentModel = "spring")
public interface EmployeeWorkConvert {
    /**
     *
     * po转dto
     * @param employeeWorkPo po对象
     * @return EmployeeWorkDto
     */
    EmployeeWorkDto po2Dto(EmployeeWorkPo employeeWorkPo);

    /**
     *
     * po集合转dto集合
     * @param employeeWorkPos po对象集合
     * @return dto集合
     */
    List<EmployeeWorkDto> po2Dtos(List<EmployeeWorkPo> employeeWorkPos);
}
