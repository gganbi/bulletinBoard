package com.study.bulletin.bulletinBoard.repository;

import com.study.bulletin.bulletinBoard.domain.Member;
import com.study.bulletin.bulletinBoard.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오후 9:48
 */
@Repository


public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Member> findByName(String name);
}

/*
public class ItemRepository {

    private final EntityManager em;
    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }
    public List<Item> findAll() {
        return em.createQuery("select i from Item i",Item.class).getResultList();
    }
}

 */