package com.heyang.mall.mapper;

import com.heyang.mall.dto.CasUser;
import com.heyang.mall.entity.UserDo;
import org.apache.ibatis.annotations.Mapper;


public interface CasUserMapper {
    UserDo selectByUserName(String userName);
}
