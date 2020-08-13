package com.yys.response; /**
 * @author Sigy
 * @date 2020/7/1 16:06
 */

import com.yys.dao.Pray;
import lombok.Data;

/**
 * @author Sigy
 * @date 2020/7/1 16:06
 */
@Data
public class PrayResponse extends Pray {
    private String memberName;
    private String name;
    private String houseName;
    private String houseArea;
}
