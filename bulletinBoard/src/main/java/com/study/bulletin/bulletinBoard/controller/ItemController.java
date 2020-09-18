package com.study.bulletin.bulletinBoard.controller;

import com.study.bulletin.bulletinBoard.domain.item.Book;
import com.study.bulletin.bulletinBoard.domain.item.Item;
import com.study.bulletin.bulletinBoard.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

/**
 * User: HolyEyE
 * Date: 2013. 12. 4. Time: 오후 9:07
 */
@Controller
@RequiredArgsConstructor

public class ItemController {

    @Autowired ItemService itemService;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * 상품 목록
     */
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String list(Model model) {

        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping(value = "/items/new")

    public String createForm(Model model) {
        model.addAttribute("form", new BookForm());

        return "items/createItemForm";

    }

    @PostMapping(value = "/items/new")

    public String create(BookForm form) {
        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());
        itemService.saveItem(book);

        return "redirect:/items";

    }



    @GetMapping(value = "/items/{itemId}/edit")

    public String updateItemForm(@PathVariable("itemId") Long itemId, Model
            model) {
        Book item = (Book) itemService.findOne(itemId);
        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());
        model.addAttribute("form", form);

        return "items/updateItemForm";

    }

    /**
     * 상품 수정
     */

    @PostMapping(value = "/items/{itemId}/edit")

    public String updateItem(@ModelAttribute("form") BookForm form) {
        Book book = new Book();
        book.setId(form.getId());
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());
        itemService.saveItem(book);

        return "redirect:/items";

    }

}
