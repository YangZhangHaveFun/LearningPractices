package nettyAnalysis.simpleServer;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;

@Slf4j
public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8000;

    private static int SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);

        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("Client starts up");
                for(;;){
                    try{
                        String message = "Hello World";
                        log.info("Client sent message: {}", message);
                        socket.getOutputStream().write(message.getBytes());
                    } catch (Exception e){
                        log.error("Exception happens while writing the data", e);
                    }
                    sleep();
                }
            }
        }).start();
    }

    public static void sleep() {
        try{
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }
}
