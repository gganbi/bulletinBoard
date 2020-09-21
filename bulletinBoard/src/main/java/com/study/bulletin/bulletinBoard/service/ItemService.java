package com.study.bulletin.bulletinBoard.service;

import com.study.bulletin.bulletinBoard.domain.item.Item;
import com.study.bulletin.bulletinBoard.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오후 9:43
 */

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional

    public void saveItem(Item item) {
        itemRepository.save(item);

    }

    public List<Item> findItems() {

        return itemRepository.findAll();

    }

    public Item findOne(Long itemId) {

        return itemRepository.findById(itemId).orElse(null);

    }
}