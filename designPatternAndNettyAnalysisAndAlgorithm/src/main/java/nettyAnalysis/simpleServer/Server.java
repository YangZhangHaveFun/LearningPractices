package nettyAnalysis.simpleServer;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;

@Slf4j
public class Server {

    private ServerSocket serverSocket;

    public Server(int port){
        try{

            this.serverSocket = new ServerSocket(port);
        } catch (IOException e){

        }
    }
}
