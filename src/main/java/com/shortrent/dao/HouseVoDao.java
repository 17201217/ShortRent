package com.shortrent.dao;

import com.shortrent.vo.HouseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface HouseVoDao {

    //得到一个假的数据表格，有房屋位置及其对应的数量
    List<HouseVo> getHouseCountVOByLocate();//根据位置找出所有房屋集合

}

