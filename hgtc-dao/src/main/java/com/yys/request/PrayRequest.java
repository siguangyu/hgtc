package com.yys.request; /**
 * @author Sigy
 * @date 2020/6/30 17:47
 */

import com.yys.dao.Pray;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sigy
 * @date 2020/6/30 17:47
 */
@Data
public class PrayRequest extends Pray {
    //1 提供 ，2 祈愿
    private String fragmentType;
    // 0 联动，1 SP，2 SSR
    private String prayType;
}
