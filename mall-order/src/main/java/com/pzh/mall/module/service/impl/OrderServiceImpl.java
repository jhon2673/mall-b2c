package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.OrderDao;
import com.pzh.mall.module.domain.CartItem;
import com.pzh.mall.module.domain.Order;
import com.pzh.mall.module.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/5 10:00
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<CartItem> listItem(long userId, List<String> itemIdList) {
        return orderDao.listItem(userId, itemIdList);
    }

    @Override
    public BigDecimal getAmount(long userId, List<String> itemIdList) {
        BigDecimal amount = BigDecimal.valueOf(0);
        List<CartItem> itemList = orderDao.listItem(userId, itemIdList);
        if (itemList != null && itemList.size() > 0) {
            for (CartItem item : itemList) {
                amount = amount.add(item.getPrice());
            }
        }
        return amount;
    }

    @Transactional
    @Override
    public void saveOrder(BigDecimal payment, BigDecimal postFee, long userId, String userNote, List<Map<Long, Integer>> itemList) {
        long orderId = orderDao.saveOrder(payment, postFee, userId, userNote);
        LOGGER.info("返回的自增长id:" + orderId);

        // 插入订单商品表
        for (Map<Long, Integer> map : itemList) {
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                orderDao.saveOrderItem(entry.getKey(), orderId, entry.getValue());
            }
        }
    }

    @Override
    public List<Order> listOrderByStatus(long userId, int status) {
        return orderDao.listOrderByStatus(userId, status);
    }

    @Override
    public List<CartItem> showDetail(long orderId) {
        return orderDao.showDetail(orderId);
    }


}
