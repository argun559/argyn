package dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CreateOrderRequest {
    @NotBlank
    private String customerName;

    @NotBlank
    private String status;

    @Valid
    @NotEmpty
    private List<CreateOrderLineRequest> lines;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CreateOrderLineRequest> getLines() {
        return lines;
    }

    public void setLines(List<CreateOrderLineRequest> lines) {
        this.lines = lines;
    }
}
