package com.dsg.innovation.ivp.websocketconnectiontest;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MessageHandler extends TextWebSocketHandler {
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //ws connection closed
        super.afterConnectionClosed(session, status);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //ws connection opened
        super.afterConnectionEstablished(session);
        session.sendMessage(new TextMessage("connection succeeded!"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //message received
        System.out.println("message received: " + message.getPayload());
        session.sendMessage(new TextMessage("message received: "+message.getPayload()));
    }
}
