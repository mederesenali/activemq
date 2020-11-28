package com.example.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jms.JMSConsumer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MessageController  {
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    Listener listener;


   List<Message> test=new ArrayList<Message>();

    @Autowired
    Queue queue;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){
        jmsTemplate.convertAndSend(queue,message);
        return "redirect:/";


    }
    @GetMapping("/messages")
    public String messages(Model model){
        model.addAttribute("messages",listener.getMessages());
        return "messages";
    }


}
