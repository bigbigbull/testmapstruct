package com.example.testmapstruct.dto;


import java.io.Serializable;


import lombok.Data;

import java.util.Date;


/**
 * <p>
 * 员工工作经历信息表
 * </p>
 *
 * @author lichangkai
 * @since 2019-08-26
 */
@Data
public class EmployeeWorkDto implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 员工索引号
     */
    private String empIndex;
    /**
     * 公司名称
     */
    private String hospName;
    /**
     * 开始时间
     */
    private Date beginAt;
    /**
     * 结束时间
     */
    private Date endAt;
    /**
     * 工作时长
     */
    private String workTime;
    /**
     * 岗位
     */
    private String post;


    /**
     * 岗位职称
     */
    private String jobTitle;

    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 材料信息（JSON格式？）
     */
    private String attach;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateAt;


}
