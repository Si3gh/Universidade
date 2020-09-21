package server;

import java.io.*;
import java.net.Socket;

public class ServerHandler extends Thread {

     private final Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Writer out = new PrintWriter(this.socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            while (true) {
                String message = in.readLine();
                if (message.equals("-END-")) {
                    out.write("fechando conexão...\n");
                    out.flush();
                    this.socket.close();
                    break;
                }
                if (message.equals("ping")) {
                    out.write("pong\n");
                    out.flush();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("ERROR", e);
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
