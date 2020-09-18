package com.study.bulletin.bulletinBoard.repository;

import com.study.bulletin.bulletinBoard.domain.Order;
import com.study.bulletin.bulletinBoard.domain.OrderSearch;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Order order) {
        em.persist(order);

    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);

    }

    public List<Order> findAll(OrderSearch orderSearch) {
        return null;
    }
}
