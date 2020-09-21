package com.study.bulletin.bulletinBoard.repository;

import com.study.bulletin.bulletinBoard.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

/*
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
*/