package com.shortrent.serviceImpl;

import com.shortrent.dao.HouseVoDao;
import com.shortrent.service.HouseVoService;
import com.shortrent.vo.BarVO;
import com.shortrent.vo.HouseVo;
import com.shortrent.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseVoServiceImpl implements HouseVoService {

    @Autowired
    private HouseVoDao houseVoDao;


    @Override
    public BarVO getBarVO() {

        List<HouseVo> list = houseVoDao.getHouseCountVOByLocate();
        List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (HouseVo houseVo : list) {
            names.add(houseVo.getType());
            values.add(houseVo.getCount());
        }
        BarVO barVO = new BarVO();
        barVO.setNames(names);
        barVO.setValues(values);
        return barVO;
    }

    @Override
    public List<PieVO> getPieVO() {
        List<HouseVo> list = houseVoDao.getHouseCountVOByLocate();
        List<PieVO> pieVOList = list.stream()
                .map(e -> new PieVO(
                        e.getCount(),
                        e.getType()
                )).collect(Collectors.toList());
        return pieVOList;
    }
}
