package com.yys.controller; /**
 * @author Sigy
 * @date 2020/6/30 14:20
 */

import com.yys.common.MsgConstants;
import com.yys.dao.House;
import com.yys.response.GenericResponse;
import com.yys.service.HouseService;
import com.yys.utils.ResponseUtils;
import com.yys.utils.SessionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sigy
 * @date 2020/6/30 14:20
 */
@Slf4j
@RestController
@RequestMapping
@Api(value = "阴阳寮相关接口", tags = "阴阳寮相关接口")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @ApiOperation(value = "阴阳寮入驻", notes = "阴阳寮入驻")
    @PostMapping("/addHouse")
    public GenericResponse add(HttpServletRequest request, @RequestBody House house) {
        house.setCreateBy(SessionUtils.getUserId(request.getSession()));
        int i = houseService.add(house);
        return i == 1 ? ResponseUtils.genSuccessResponse() : ResponseUtils.genErrorResponse(MsgConstants.MSG_SYSTEM_ERR);
    }



}
