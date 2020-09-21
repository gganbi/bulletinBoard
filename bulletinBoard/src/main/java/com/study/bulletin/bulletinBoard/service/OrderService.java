package com.study.bulletin.bulletinBoard.service;

import com.study.bulletin.bulletinBoard.domain.*;
import com.study.bulletin.bulletinBoard.domain.item.Item;
import com.study.bulletin.bulletinBoard.repository.MemberRepository;
import com.study.bulletin.bulletinBoard.repository.OrderRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Getter
@Setter
public class OrderService {

    private final MemberRepository memberRepository;

    private final OrderRepository orderRepository;

    private final ItemService itemService;

    /** 주문 */

    @Transactional

    public Long order(Long memberId, Long itemId, int count) {

//엔티티 조회
        Member member = memberRepository.findById(memberId).orElse(null);
        Item item = itemService.findOne(itemId);

//배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

//주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(),
                count);
        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

//주문 저장
        orderRepository.save(order);

        return order.getId();

    }

    /** 주문 취소 */

    @Transactional

    public void cancelOrder(Long orderId) {

//주문 엔티티 조회
        Order order = orderRepository.findById(orderId).orElse(null);

//주문 취소
        order.cancel();

    }

/** 주문 검색 */
/*  이거 쿼리dsl 필요 나중에 추가하기
 public List<Order> findOrders(OrderSearch orderSearch) {
    return orderRepository.findAll(orderSearch);
 }
*/
}
