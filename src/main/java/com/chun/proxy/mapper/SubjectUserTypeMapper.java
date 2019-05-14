package com.chun.proxy.mapper;

//import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.chun.proxy.entity.SubjectUserType;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 专题用户类型关联表 Mapper 接口
 * </p>
 *
 * @author zhangbin
 * @since 2017-04-18
 */
public interface SubjectUserTypeMapper //extends BaseMapper<SubjectUserType>
 {


    Integer save(@Param("param") SubjectUserType userType);

    Integer saveInterface(@Param("param") SubjectUserType userType);

    //@@Param无效，直接取#{id}
    Integer saveXml(@Param("param") SubjectUserType userType);

}