package com.gmail.clarkin200.coffeeshop;

import org.slf4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class CoffeeOrderBoard {

    private final List<Order> repository = new LinkedList<>();
    private static final Logger log = MultiLogger.loadLogger("logback-coffeeshop.xml");

    public boolean add(String orderName) {
        if(orderName == null){
            log.warn("Error create order. order name is null");
            return false;
        }
        if (!orderName.isBlank()) {
            Order addedOrder;
            if (repository.isEmpty()) {
                addedOrder = new Order(1L, orderName);
                repository.addLast(addedOrder);
            } else {
                addedOrder = new Order(repository.getLast().getId() + 1L, orderName);
                repository.addLast(addedOrder);
            }
            log.info("Add order {}", addedOrder);
            return true;
        } else {
            log.warn("Order didn't create: invalid order name");
            return false;
        }
    }

    public void deliver() {
        if(repository.isEmpty()){
            log.warn("Error deliver. Deliver list is empty");
            return;
        }
        Order deletedOrder = repository.removeFirst();
        log.info("Deliver order : {}",deletedOrder);
    }

    public void deliver(Long id) {
        if(repository.isEmpty()){
            log.warn("Error deliver by ID. Deliver list is empty");
            return;
        }
        if(id == null){
            log.warn("Error deliver by ID. id is null");
            return;
        }
        if(repository.removeIf(order -> order.getId() == id)){
            log.info("Order with id: {} deleted",id);
        }
        log.warn("Order with id: {} not found",id);

    }

    public void draw() {
        repository.forEach(System.out::println);
    }


}
