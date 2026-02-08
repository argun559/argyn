package model;

import jakarta.persistence.*;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Order order;

    @ManyToOne(optional = false)
    private MediaContent media;

    private Integer quantity;

    public OrderLine() {}

    public OrderLine(MediaContent media, Integer quantity) {
        this.media = media;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MediaContent getMedia() {
        return media;
    }

    public void setMedia(MediaContent media) {
        this.media = media;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
