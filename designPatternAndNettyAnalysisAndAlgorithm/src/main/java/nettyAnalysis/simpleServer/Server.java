package nettyAnalysis.simpleServer;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {

    private ServerSocket serverSocket;

    public Server(int port){
        try{
            this.serverSocket = new ServerSocket(port);
            log.info("Server started successfully");
        } catch (IOException e){
            log.error("Server failed to start", e);
        }
    }

    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    public void doStart(){
        for (;;){
            try{
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e){
                log.error("Server got exception", e);
            }
        }
    }
}
