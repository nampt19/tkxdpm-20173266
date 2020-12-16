package com.oms.bean;

import java.util.*;

public class Order {
    private String id;
    private String code;
    private String customerName;
    private String customerPhoneNumber;
    private String customerAddress;
    private ArrayList<OrderLine> orderLines;
    private float totalCost;

    public Order() {
        orderLines = new ArrayList<OrderLine>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    //	public float getTotalCost() {
//		float res = 0;
//		if (orderLines!= null) {
//			Iterator<OrderLine> iter = orderLines.iterator();
//			while (iter.hasNext()) {
//				OrderLine ol = iter.next();
//				res +=  ol.getProductCost() * ol.getProductQuantity();
//			}
//		}
//		return res;
//	}
    public float getTotalCost() {
        float res = 0;
        float weight = 0;
        int sodu = 0;
        if (orderLines != null) {
            Iterator<OrderLine> iter = orderLines.iterator();
            while (iter.hasNext()) {
                OrderLine ol = iter.next();
                res += ol.getProductCost() * ol.getProductQuantity();
                weight += ol.getProductQuantity() * ol.getWeight();
            }
        }
        if (res >= 500000.0f) {
            return res;
        } else if (res > 0 && res < 500000.0f) {
            System.out.println("Địa chỉ KH: " + customerAddress.toLowerCase());
            System.out.println("Ở HN hoặc HCM:" + checkLocationCustomerHaNoiOrHoChiMinh(customerAddress));

            if (checkLocationCustomerHaNoiOrHoChiMinh(customerAddress)) {
                if (weight <= 0) return 0;
                else if (weight > 0 && weight <= 3) return res + 22000;
                else {
                    float weightFee = (float) ((weight - 3) / 0.5);
                    sodu = (int) ((float) weightFee > (int) weightFee ? (int) weightFee + 1 : (int) weightFee);
                    return res + 22000 + sodu * 2500;
                }
            } else {
                if (weight <= 0) return 0;
                if (weight > 0 && weight <= 0.5) return res + 30000;
                else {
                    float weightFee = (float) ((weight - 0.5) / 0.5);
                    sodu = (int) ((float) weightFee > (int) weightFee ? (int) weightFee + 1 : (int) weightFee);
                    return res + 30000 + sodu * 2500;
                }
            }
        } else {
            return 0;
        }
    }

    private boolean checkLocationCustomerHaNoiOrHoChiMinh(String customerAddress) {
        boolean flag = false;
        String res = customerAddress.toLowerCase();
        if (res.equals("hn")
                || res.equals("hcm")
                || res.equals("hà nội")
                || res.equals("hồ chí minh")) {
            flag = true;
        }
        return flag;
    }


    public void addOrderLine(OrderLine orderLine) {
        boolean existed = false;
        for (OrderLine ol : orderLines) {
            if (ol.getProductId().equals(orderLine.getProductId())) {
                ol.setProductQuantity(ol.getProductQuantity() + orderLine.getProductQuantity());
                existed = true;
                break;
            }
        }

        if (!existed) {
            orderLines.add(orderLine);
        }
    }

    public boolean search(Order order) {
        if (this.id != null && !this.id.equals("") && !this.id.contains(order.id)) {
            return false;
        }
        if (this.code != null && !this.code.equals("") && !this.code.contains(order.code)) {
            return false;
        }
        if (this.customerName != null && !this.customerName.equals("") && !this.customerName.contains(order.customerName)) {
            return false;
        }
        if (this.totalCost != 0 && this.totalCost != order.totalCost) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order) {
            return this.code.equals(((Order) obj).code);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", orderLines=" + orderLines +
                ", totalCost=" + totalCost +
                '}';
    }
}