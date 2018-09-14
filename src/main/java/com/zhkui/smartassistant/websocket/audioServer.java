package com.zhkui.smartassistant.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@ServerEndpoint("/audio")
@Component
public class audioServer {

    private static Logger mLog = LoggerFactory.getLogger(audioServer.class);
    private Session mSession;
    private List<audioServer> sWebSocketServers = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session){
        mSession = session;
        sWebSocketServers.add(this); // 将回话保存
        mLog.info("-->onOpen new connect");
    }

    @OnClose
    public void onClose(){
        sWebSocketServers.remove(this);
        mLog.info("-->onClose a connect");
    }

    @OnMessage
    public void onMassage(byte[] massage){
        mLog.info("-->receive a massage:");
        mLog.info(massage.toString());
    }

    public void sendMassage(byte[] massage){
        ByteBuffer buffer = ByteBuffer.wrap(massage);
        try {
            mSession.getBasicRemote().sendBinary(buffer);
        } catch (IOException e) {
            mLog.error(e.toString());
        }
    }
}
