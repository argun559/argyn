package service;

import dto.CreateOrderLineRequest;
import dto.CreateOrderRequest;
import exception.NotFoundException;
import model.Customer;
import model.MediaContent;
import model.Order;
import model.OrderLine;
import patterns.builder.OrderBuilder;
import patterns.singleton.LoggingService;
import repository.MediaContentRepository;
import repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final MediaContentRepository mediaRepo;

    public OrderService(OrderRepository orderRepo, MediaContentRepository mediaRepo) {
        this.orderRepo = orderRepo;
        this.mediaRepo = mediaRepo;
    }

    public Order create(CreateOrderRequest req) {
        LoggingService.getInstance().info("create order for: " + req.getCustomerName());

        Customer customer = new Customer(req.getCustomerName());

        Order order = new OrderBuilder()
                .customer(customer)
                .createdAt(LocalDateTime.now())
                .status(req.getStatus())
                .build();

        for (CreateOrderLineRequest lineReq : req.getLines()) {
            MediaContent media = mediaRepo.findById(lineReq.getMediaId())
                    .orElseThrow(() -> new NotFoundException("media not found: " + lineReq.getMediaId()));
            OrderLine line = new OrderLine(media, lineReq.getQuantity());
            order.addLine(line);
        }

        return orderRepo.save(order);
    }

    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    public Order findById(Long id) {
        return orderRepo.findById(id).orElseThrow(() -> new NotFoundException("order not found: " + id));
    }

    public void delete(Long id) {
        Order order = findById(id);
        orderRepo.delete(order);
    }
}
