package com.pzh.mall.module.dao;

import com.pzh.mall.module.domain.CartItem;
import com.pzh.mall.module.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/5 9:59
 * @Version 1.0
 */
@Mapper
public interface OrderDao {

    /**
     * 列出所有结算商品
     * @param userId
     * @param itemIdList
     * @return
     */
    List<CartItem> listItem(long userId, List<String> itemIdList);

    /**
     * 保存订单
     * @param payment
     * @param postFee
     * @param userId
     * @param userNote
     * @return 自增长id
     */
    long saveOrder(BigDecimal payment, BigDecimal postFee, long userId, String userNote);

    /**
     * 保存订单商品
     * @param itemId
     * @param orderId
     * @param num
     */
    void saveOrderItem(long itemId, long orderId, int num);

    /**
     * 根据订单状态列出所有订单
     * @param status
     * @return
     */
    List<Order> listOrderByStatus(long userId, int status);

    /**
     * 查看订单商品详情
     * @param orderId
     * @return
     */
    List<CartItem> showDetail(long orderId);
}
