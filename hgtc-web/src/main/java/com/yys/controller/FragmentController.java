package com.yys.controller;

import com.yys.common.MsgConstants;
import com.yys.dao.Fragment;
import com.yys.response.GenericResponse;
import com.yys.service.FragmentService;
import com.yys.utils.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sigy
 * @date 2020/6/30 10:29
 */
@Slf4j
@RestController
@RequestMapping("fragment")
@Api(value = "yys式神碎片导入",tags = "用于规范祈愿式神名称的正确性，目前只导入sp和ssr")
public class FragmentController {

    @Autowired
    private FragmentService fragmentService;

    @PostMapping("add")
    @ApiOperation(value = "新增", notes = "名称和等级导入数据库，1为sp，2为ssr，3为sr,4为r,5为n")
    public GenericResponse add(@RequestBody Fragment fragment){
        int i =  fragmentService.add(fragment);
        return i==1?ResponseUtils.genSuccessResponse():ResponseUtils.genErrorResponse(MsgConstants.MSG_SYSTEM_ERR);
    }
    @GetMapping("showList")
    @ApiOperation(value = "查看式神碎片列表", notes = "查看式神碎片列表")
    public GenericResponse showList(){
        return ResponseUtils.genSuccessResponse( fragmentService.all());
    }

}
