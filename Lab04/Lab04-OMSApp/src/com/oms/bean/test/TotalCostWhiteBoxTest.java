package com.oms.bean.test;

import com.oms.bean.Book;
import com.oms.bean.Order;
import com.oms.bean.OrderLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class TotalCostWhiteBoxTest {
    private Order order;
    private float expected;

    public TotalCostWhiteBoxTest(Order order, float expected) {
        this.order = order;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Order({0}) = totalCost{1}")
    public  static Collection<Object[]> primeNumbers(){
        Order order1 = new Order();
        order1.setCustomerAddress("no hn");
        List<OrderLine> orderLines1 = new ArrayList<>();
        OrderLine orderLine1 = new OrderLine();
        orderLine1.setProductCost(150000.0f);
        orderLine1.setProductQuantity(1);
        orderLine1.setWeight(1.2f);
        orderLines1.add(orderLine1);
        order1.setOrderLines((ArrayList<OrderLine>) orderLines1);

        Order order2 = new Order();
        order2.setCustomerAddress("hn");
        List<OrderLine> orderLines2 = new ArrayList<>();
        OrderLine orderLine2 = new OrderLine();
        orderLine2.setProductCost(150000.0f);
        orderLine2.setProductQuantity(3);
        orderLine2.setWeight(1.2f);
        orderLines2.add(orderLine2);
        order2.setOrderLines((ArrayList<OrderLine>) orderLines2);

        return Arrays.asList(new Object[][]{
                {order1,185000.0f},
                {order2,477000.0f}
        });
    }

    @Test
    public void testGetTotalCost() {
        assertTrue("check : ",order.getTotalCost() == expected);
    }
}
