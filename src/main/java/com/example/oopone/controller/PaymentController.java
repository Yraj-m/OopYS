package com.example.oopone.controller;

import com.example.oopone.dto.PaymentUserDto;
import com.example.oopone.dto.UserDto;
import com.example.oopone.model.RazorPay;
import com.example.oopone.model.Response;
import com.example.oopone.model.User;
import com.example.oopone.repository.UserRepo;
import com.example.oopone.service.CartItemsService;
import com.example.oopone.service.UserService;
import com.google.gson.Gson;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
public class PaymentController {


    @Autowired
    CartItemsService cartItemsService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;




    private RazorpayClient client;
    private static Gson gson = new Gson();

    private static final String SECRET_ID = "rzp_test_SggHu4tVNZOzjj";
    private static final String SECRET_KEY = "DJpD92n4rxWvvC3B07LyG9bD";



    public PaymentController() throws RazorpayException {
        this.client =  new RazorpayClient(SECRET_ID, SECRET_KEY);
    }

    @PostMapping(value="/add/wallet")
    public ResponseEntity<String> createOrder(@RequestBody PaymentUserDto paymentUserDto) {
        User user = userRepo.findUserByEmailid(paymentUserDto.getEmailid()).get();
        System.out.println(user);
        try {

            Order order = createRazorPayOrder( String.valueOf(paymentUserDto.getAmt_to_add()));
            RazorPay razorPay = getRazorPay((String)order.get("id"), paymentUserDto);
            System.out.println(user.getWallet_amt());
            System.out.println(user.getWallet_amt() + paymentUserDto.getAmt_to_add());
            user.setWallet_amt(user.getWallet_amt() + paymentUserDto.getAmt_to_add());
            System.out.println(user.getWallet_amt());
            System.out.println(user);
            userService.updateUserWallet(user);
            return new ResponseEntity<String>(gson.toJson(getResponse(razorPay, 200)),
                    HttpStatus.OK);
        } catch (RazorpayException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(gson.toJson(getResponse(new RazorPay(), 500)),
                HttpStatus.EXPECTATION_FAILED);
    }

    private Response getResponse(RazorPay razorPay, int statusCode) {
        Response response = new Response();
        response.setStatusCode(statusCode);
        response.setRazorPay(razorPay);
        return response;
    }

    private RazorPay getRazorPay(String orderId, PaymentUserDto paymentUserDto) {
        RazorPay razorPay = new RazorPay();
        razorPay.setApplicationFee(convertRupeeToPaise(String.valueOf(paymentUserDto.getAmt_to_add())));
        razorPay.setCustomerName(paymentUserDto.getUsername());
        razorPay.setCustomerEmail(paymentUserDto.getEmailid());
        razorPay.setMerchantName("Test");
        razorPay.setPurchaseDescription("TEST PURCHASES");
        razorPay.setRazorpayOrderId(orderId);
        razorPay.setSecretKey(SECRET_ID);
        razorPay.setImageURL("/logo");
        razorPay.setTheme("#F37254");
        razorPay.setNotes("notes"+orderId);

        return razorPay;
    }

    private Order createRazorPayOrder(String amount) throws RazorpayException {

        JSONObject options = new JSONObject();
        options.put("amount", convertRupeeToPaise(amount));
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        options.put("payment_capture", 1); // You can enable this if you want to do Auto Capture.
        return client.orders.create(options);
    }

    private String convertRupeeToPaise(String paise) {
        BigDecimal b = new BigDecimal(paise);
        BigDecimal value = b.multiply(new BigDecimal("100"));
        return value.setScale(0, RoundingMode.UP).toString();

    }


}