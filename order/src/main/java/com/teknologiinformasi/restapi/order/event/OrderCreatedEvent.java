package com.teknologiinformasi.restapi.order.event;
import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderCreatedEvent implements Serializable {
    private String orderId;
   private Long productId;
   private int quantity;
   private LocalDateTime OrderDate;
   private String orderStatus; // misal: CREATED
   public OrderCreatedEvent() {}
   public OrderCreatedEvent(String id, Long productId, int quantity, LocalDateTime OrderDate, String orderStatus) {
       this.orderId = id;
       this.productId = productId;
       this.quantity = quantity;
       this.OrderDate = OrderDate;
       this.orderStatus = orderStatus;
   }
   // Getters & Setters
   public String  getid() {
       return orderId;
   }
   public void setid(String id) {
       this.orderId = id;
   }
   public Long getProductId() {
       return productId;
   }
   public void setProductId(Long productId) {
       this.productId = productId;
   }
   public int getQuantity() {
       return quantity;
   }
   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }
   public LocalDateTime getOrderDate() {
       return OrderDate;
   }
   public void setOrderDate(LocalDateTime OrderDate) {
       this.OrderDate = OrderDate;
   }
   public String getOrderStatus() {
       return orderStatus;
   }
   public void setOrderStatus(String orderStatus) {
       this.orderStatus = orderStatus;
   }
   @Override
   public String toString() {
       return "OrderCreatedEvent{" +
               "id=" + orderId +
               ", productId=" + productId +
               ", quantity=" + quantity +
               ", OrderDate=" + OrderDate +
               ", orderStatus='" + orderStatus + '\'' +
               '}';
   }
}
