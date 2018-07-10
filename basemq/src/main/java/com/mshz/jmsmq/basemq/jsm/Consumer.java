package com.mshz.jmsmq.basemq.jsm;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class Consumer implements MessageListener {

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text) {
     System.out.println(text);
    }

    @Override
    public void onMessage(Message message) {
        System.out.println(message);
    }
}
