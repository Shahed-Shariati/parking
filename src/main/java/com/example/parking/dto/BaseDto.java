package com.example.parking.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BaseDto {

    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = false,hidden = true)
    private Integer version;

    @ApiModelProperty(required = false,hidden = true)
    private Date createDate;

    @ApiModelProperty(required = false,hidden = true)
    private Date lastModifiedDate;

    @ApiModelProperty(required = false,hidden = true)
    private String createBy;

    @ApiModelProperty(required = false,hidden = true)
    private String lastModifiedBy;
}
