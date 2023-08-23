package org.kainos.ea.api;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.Product;
import org.kainos.ea.client.FailedToGetOrdersException;
import org.kainos.ea.client.FailedToGetProductsException;
import org.kainos.ea.client.OrderDoesNotExistException;
import org.kainos.ea.client.ProductDoesNotExistException;
import org.kainos.ea.db.OrderDao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

public class OrderService {
    private OrderDao orderDao = new OrderDao();
    public List<Order> getAllOrders() throws FailedToGetOrdersException {

        List<Order> orderList = null;
        try {
            orderList = orderDao.getAllOrders();
            return orderList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetOrdersException();
        }


        //orderList.stream().forEach(System.out::println);

        /*Collections.sort(orderList, Collections.reverseOrder());
        orderList.stream().forEach(System.out::println);*/

        /*long oneWeekAgoMillis = System.currentTimeMillis() - (2 * 24 * 60 * 60 * 1000);
        Date oneWeekAgo = new Date(oneWeekAgoMillis);
        orderList.stream().filter(order -> order.getOrderDate().after(oneWeekAgo)).forEach(System.out::println);*/

        /*List<Order> customerId1 = orderList.stream().filter(order -> order.getCustomerId() == 1).collect(Collectors.toList());
        customerId1.forEach(System.out::println);*/

        /*Collections.sort(orderList, Collections.reverseOrder());
        System.out.println(orderList.get(0));*/

        //Collections.sort(orderList);
        //System.out.println(orderList.get(0));
        //System.out.println(orderList.size());

        /*List<Integer> customerIds = new ArrayList<Integer>();
        for (Order order: orderList) {
            customerIds.add(order.getCustomerId());
        }
        //System.out.println(MostCommon(customerIds));
        System.out.println(LeastCommon(customerIds)); */

    }

    public Integer MostCommon(List<Integer> integerList) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of integers
        for (Integer num : integerList) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find the most common integer
        int mostCommonInteger = Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        return mostCommonInteger;
    }

    public Integer LeastCommon(List<Integer> integerList) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of integers
        for (Integer num : integerList) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find the most common integer
        int leastCommonInteger = Collections.min(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        return leastCommonInteger;
    }

    public Order getOrderById(int id) throws FailedToGetOrdersException, OrderDoesNotExistException {
        try{
            Order order = orderDao.getOrderById(id);
            if (order == null){
                throw new OrderDoesNotExistException();
            }

            return order;

        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetOrdersException();
        }
    }



}
