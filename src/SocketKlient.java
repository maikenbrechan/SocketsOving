import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class SocketKlient {
    public static void main(String[] args) throws IOException, ScriptException {
        int portNR = 1970;

    Scanner readCMD = new Scanner(System.in);
    System.out.print("Programmet kjører! ");
    Socket connection = new Socket("localhost", portNR);

    InputStreamReader readConnetion = new InputStreamReader(connection.getInputStream());
    BufferedReader reader = new BufferedReader(readConnetion);
    PrintWriter writer = new PrintWriter(connection.getOutputStream(), true);

    String line = readCMD.nextLine();



    while (!line.equals("")) {
        try {
            writer.println(line);
            System.out.println("It is the servers turn now");
            line = readCMD.nextLine();
        } catch (Exception e){
            System.out.println("There was an error in the calculation, run the program again.");
        }
    }

    reader.close();
    writer.close();
    connection.close();
}

}
