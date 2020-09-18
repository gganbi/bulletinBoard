package com.study.bulletin.bulletinBoard.repository.custom;

import com.study.bulletin.bulletinBoard.domain.Order;
import com.study.bulletin.bulletinBoard.domain.OrderSearch;

import java.util.List;

/**
 * @author holyeye
 */
public interface CustomOrderRepository {

    public List<Order> search(OrderSearch orderSearch);

}
