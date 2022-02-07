package com.Evaluacion1.CalculatorAndWebServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercise_07_Server {
    public static void main(String[] args) throws IOException {
        //Calculator Server. Receive two number and a operation, the server sends the result.
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket client = serverSocket.accept();

        InputStreamReader isr = new InputStreamReader(client.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        PrintStream output = new PrintStream(client.getOutputStream(), true);

        double n1, n2;
        String result;
        String operation;

        do {
            n1 = Double.parseDouble(br.readLine());
            n2 = Double.parseDouble(br.readLine());
            operation = br.readLine();

            result = "";
            switch (operation.toLowerCase()) {
                case "suma":
                    result = String.valueOf(n1 + n2);
                    break;
                case "resta":
                    result = String.valueOf(n1 - n2);
                    break;
                case "multiplicacion":
                    result = String.valueOf(n1 * n2);
                    break;
                case "division":
                    if(n2 != 0) {
                        result = String.valueOf(n1 / n2);
                    } else {
                        result = "Error! Zero division.";
                    }
                    break;
                default:
                    result = "Error! operation not identified.";
                    break;
            }

            output.println(result);
        } while(!br.readLine().equals("end"));

        client.close();
        br.close();
        output.close();
        serverSocket.close();
    }
}