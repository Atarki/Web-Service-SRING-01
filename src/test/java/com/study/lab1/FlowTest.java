package com.study.lab1;

import com.study.lab1.handler.RequestHandler;
import com.study.lab1.model.Account;
import com.study.lab1.model.Request;
import com.study.lab1.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class FlowTest {

    @Autowired
    private RequestHandler requestHandler;

    @Test
    public void testSuccessWidthdrawRequest() {
        AccountService accountService = requestHandler.getAccountService();

        // prepare
        Account accountFromBeforeRequest = accountService.getAccount(1);
        Account accountToBeforeRequest = accountService.getAccount(2);
        System.out.println("<===Before widthdraw===>");
        System.out.println(accountFromBeforeRequest);
        System.out.println(accountToBeforeRequest);

        Request request = new Request();
        request.setAccountFromId(1);
        request.setAccountToId(2);
        request.setOperation("w");
        request.setUserId(1);

        // action
        requestHandler.handle(request);

        // check
        Account accountFromAfterRequest = accountService.getAccount(1);
        Account accountToAfterRequest = accountService.getAccount(2);
        System.out.println("<===After widthdraw===>");
        System.out.println(accountFromAfterRequest);
        System.out.println(accountToAfterRequest);

        double allMoneyBefore = accountFromBeforeRequest.getBalance() + accountToBeforeRequest.getBalance();
        double allMoneyAfter = accountFromAfterRequest.getBalance() + accountToAfterRequest.getBalance();

        assertFalse(accountFromBeforeRequest.getBalance() == accountFromAfterRequest.getBalance());
        assertFalse(accountToBeforeRequest.getBalance() == accountToAfterRequest.getBalance());
        assertEquals(allMoneyBefore, allMoneyAfter, 0.1);
    }

    @Test
    public void testSuccessCounterbalanceRequest() {
        AccountService accountService = requestHandler.getAccountService();

        // prepare
        Account accountFromBeforeRequest = accountService.getAccount(1);
        Account accountToBeforeRequest = accountService.getAccount(2);
        System.out.println("<===Before counterbalance===>");
        System.out.println(accountFromBeforeRequest);
        System.out.println(accountToBeforeRequest);

        Request request = new Request();
        request.setAccountFromId(1);
        request.setAccountToId(2);
        request.setOperation("cb");
        request.setUserId(1);

        // action
        requestHandler.handle(request);

        // check
        Account accountFromAfterRequest = accountService.getAccount(1);
        Account accountToAfterRequest = accountService.getAccount(2);
        System.out.println("<===After counterbalance===>");
        System.out.println(accountFromAfterRequest);
        System.out.println(accountToAfterRequest);

        double allMoneyBefore = accountFromBeforeRequest.getBalance() + accountToBeforeRequest.getBalance();
        double allMoneyAfter = accountFromAfterRequest.getBalance() + accountToAfterRequest.getBalance();

        assertEquals(allMoneyBefore, allMoneyAfter, 0.1);
        assertEquals(accountFromAfterRequest.getBalance(), accountToAfterRequest.getBalance(), 0.1);
    }
}
