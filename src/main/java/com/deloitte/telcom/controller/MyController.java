package com.deloitte.telcom.controller;

import com.deloitte.telcom.dao.ICustomerServiceDao;
import com.deloitte.telcom.dto.SessionData;
import com.deloitte.telcom.entities.CustomerService;
import com.deloitte.telcom.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class MyController {

    @Controller
    public class HelloController {

        private ICustomerService service;

        public ICustomerService getService() {
            return service;
        }

        @Autowired
        public void setService(ICustomerService service) {
            this.service = service;
        }

        private SessionData sessionData;

        @Autowired
        public void setSessionData(SessionData data) {
            this.sessionData = data;

        }

        public SessionData getSessionData() {
            return sessionData;
        }


        @GetMapping("/userinput")
        public ModelAndView userInput() {
            System.out.println("inside userinput");
            return new ModelAndView("userinput");
        }

        @GetMapping("/logincheck")
        public RedirectView loginCheck(@RequestParam("mobileno") String mobileno,
                                       @RequestParam("name") String name) {

            boolean correct = service.credentialsCorrect(mobileno, name);
            if (!correct) {
                return new RedirectView("/userinput");
            }
            CustomerService cs = service.customerDetails(mobileno);
            sessionData.setCustomer(cs);
            return new RedirectView("/home");
        }

        @GetMapping("/home")
        public Object home() {
            if (sessionData.getCustomer() == null) {
                return new RedirectView("/userinput");
            }
            CustomerService cs = sessionData.getCustomer();
            ModelAndView mv = new ModelAndView("home", "user", cs);
            return mv;
        }


    }

}
