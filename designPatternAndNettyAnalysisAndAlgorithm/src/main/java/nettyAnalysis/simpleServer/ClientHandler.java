package nettyAnalysis.simpleServer;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

@Slf4j
public class ClientHandler {

    private Socket socket;
    private static int MAX_DATA_LEN = 1024;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    public void start(){
        log.info("New client has been connected.");
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    public void doStart(){
        try{
            InputStream inputStream = socket.getInputStream();
            for(;;){
                byte[] data = new byte[MAX_DATA_LEN];
                int len;
                while((len = inputStream.read(data)) != -1){
                    String message = new String(data, 0 , len);
                    log.info("Received from client: {}", message);
                    socket.getOutputStream().write(data);
                }
            }
        } catch (IOException e){
            log.error("Server exception happens", e);
        }
    }
}
