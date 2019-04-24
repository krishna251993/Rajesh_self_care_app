package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.constants.PageNavigation;
import com.selfcare.imcl.pages.CreateTicketPage;
import com.selfcare.imcl.pages.TicketPage;
import org.testng.annotations.Test;

public class TicketTest extends BaseTest {
    PageNavigation pagenavigation;
    TicketPage ticketpage;
    CreateTicketPage createTicket;

    @Test(priority = 13,enabled = true)
    public void ticket() throws InterruptedException {
        pagenavigation = new PageNavigation(driver);
        ticketpage = new TicketPage(driver);
        createTicket = new CreateTicketPage(driver);

        pagenavigation.Ticket_Navigation();
        ticketpage.filterTicket();

        pagenavigation.Ticket_Navigation();
        createTicket.ticketCreate();
    }
}