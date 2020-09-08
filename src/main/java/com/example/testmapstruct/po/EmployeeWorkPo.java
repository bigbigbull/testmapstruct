package com.example.testmapstruct.po;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lichangkai
 * @date 2020-09-06
 */
@Data
@Builder
public class EmployeeWorkPo implements Serializable{

    private static final long serialVersionUID = 2L;
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
