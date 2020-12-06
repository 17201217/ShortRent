package com.shortrent.service;

import com.shortrent.vo.BarVO;
import com.shortrent.vo.HouseVo;
import com.shortrent.vo.PieVO;

import java.util.Collection;
import java.util.List;

public interface HouseVoService {
    //得到一个假的数据表格，有房屋位置及其对应的数量

    public BarVO getBarVO();
    public List<PieVO> getPieVO();


}
