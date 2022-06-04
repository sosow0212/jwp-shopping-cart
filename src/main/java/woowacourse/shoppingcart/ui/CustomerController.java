package woowacourse.shoppingcart.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import woowacourse.auth.support.AuthenticationPrincipal;
import woowacourse.shoppingcart.application.CustomerService;
import woowacourse.shoppingcart.dto.ChangeCustomerRequest;
import woowacourse.shoppingcart.dto.ChangePasswordRequest;
import woowacourse.shoppingcart.dto.CreateCustomerRequest;
import woowacourse.shoppingcart.dto.CustomerResponse;

import java.net.URI;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CreateCustomerRequest request) {
        Long customerId = customerService.createCustomer(request);
        return ResponseEntity.created(URI.create("/api/customers/" + customerId)).build();
    }

    @GetMapping("/me")
    public ResponseEntity<CustomerResponse> showCustomer(@AuthenticationPrincipal String email) {
        CustomerResponse customerResponse = customerService.findCustomerByEmail(email);
        return ResponseEntity.ok(customerResponse);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@AuthenticationPrincipal String email) {
        customerService.deleteCustomer(email);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/password")
    public ResponseEntity<Void> changePassword(@AuthenticationPrincipal String email, @RequestBody ChangePasswordRequest request) {
        customerService.changePassword(email, request);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<Void> changeNickname(@AuthenticationPrincipal String email, @RequestBody ChangeCustomerRequest request) {
        customerService.changeNickname(email, request);
        return ResponseEntity.ok().build();
    }
}