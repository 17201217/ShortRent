package com.shortrent.rest;

import com.shortrent.error.ShortRentErrorMessage;
import com.shortrent.error.ShortRentException;
import com.shortrent.pojo.House;
import com.shortrent.service.HouseService;
import com.shortrent.service.HouseVoService;
import com.shortrent.vo.BarVO;
import com.shortrent.vo.HouseVo;
import com.shortrent.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/housevo")
public class HouseVoRestController {

	@Autowired
	private HouseVoService houseVoService;


	@RequestMapping("/barVO")
	@ResponseBody
	public BarVO getBarVO() {
		return houseVoService.getBarVO();
	}



	@RequestMapping("/pieVO")
	@ResponseBody
	public List<PieVO> getPieVO() {
		return houseVoService.getPieVO();
	}

}
