package client;

import server.PingPongServer;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingPongClient {
    public PingPongClient() {
    }

    public static void main(String[] args) {
        PingPongClient client = new PingPongClient();
        client.run();
    }

    private void run() {
        try {
            Socket connection = new Socket(PingPongServer.HOSTNAME, PingPongServer.PORT);

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                PrintWriter out = new PrintWriter(connection.getOutputStream());
                int pingsThrown = 0;

                while(true) {
                    if (pingsThrown >= 1000) {
                        out.write("end\n");
                        out.flush();
                        System.out.println(in.readLine());
                        break;
                    }

                    out.write("ping\n");
                    out.flush();
                    String message = in.readLine();
                    System.out.println(message);
                    ++pingsThrown;
                }
            } catch (Throwable var7) {
                try {
                    connection.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            connection.close();
        } catch (UnknownHostException e) {
            System.out.println("UnkownHostException: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("IOException: " + ioException.getMessage());
            ioException.printStackTrace();
        }

    }
}
