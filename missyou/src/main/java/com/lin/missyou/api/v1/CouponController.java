package com.lin.missyou.api.v1;


import com.lin.missyou.vo.CouponPureVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
public class CouponController {
    // 进入详情后查询当前spu对应的优惠券
    // 逻辑关系
    // coupon查询 根据分类来查询
    // 每个spu肯定是所属某一个分类的
    // 所以先查询当前spu所属费分类
    public List<CouponPureVO> getCategoryById() {

    }
}
