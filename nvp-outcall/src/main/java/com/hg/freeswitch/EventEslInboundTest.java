package com.hg.freeswitch;

import org.freeswitch.esl.client.IEslEventListener;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.inbound.InboundConnectionFailure;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by litong on 2018/1/4.
 * @msg 测试连接freeswitch服务器
 * @see http://blog.csdn.net/coolyqq/article/details/51436854
 */
public class EventEslInboundTest {
    private static Logger log = LoggerFactory.getLogger(EventEslInboundTest.class);
    private static String host="192.168.28.105";
    private static int port=8021;
    private static String password="ClueCon";

    public void inBean(){
        final Client client=new Client();

        try {
            client.connect(host,port,password,10);
        } catch (InboundConnectionFailure inboundConnectionFailure) {
            inboundConnectionFailure.printStackTrace();
            // exit program
            return;
        }
        // add listen
        client.addEventListener(new IEslEventListener() {
            @Override
            public void eventReceived(EslEvent eslEvent) {
                System.out.println("event received "+eslEvent.getEventHeaders());

            }

            @Override
            public void backgroundJobResultReceived(EslEvent eslEvent) {

            }
        });
    }

    public static void main(String[] args) {


    }
}
