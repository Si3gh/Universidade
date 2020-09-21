package server;

import java.net.ServerSocket;

public class PingPongServer {

   public static final int PORT = 8081;
    public static final String HOSTNAME = "localhost";

    public static void main(String[] args) {
        PingPongServer pingServer = new PingPongServer();
        pingServer.runServer();
    }

    private void runServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                ServerHandler pingPongServerHandler = new ServerHandler(serverSocket.accept());
                System.out.println("Request received" + pingPongServerHandler.getName());
                pingPongServerHandler.start();
                System.out.println("Request handled");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error", e);
        }
    }
}
