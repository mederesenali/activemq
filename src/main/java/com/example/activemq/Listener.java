package com.example.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Listener {
    List<String> messages=new ArrayList<>();
    @JmsListener(destination = "msg")
    public void consume(String message) {
        messages.add(message);
        System.out.println("Received Message: " + message);
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
