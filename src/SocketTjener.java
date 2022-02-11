import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class SocketTjener {
    public static void main(String[] args) throws IOException {
        final int portNR = 1970;

        ServerSocket tjener = new ServerSocket(portNR);
        Socket connection = tjener.accept();

        InputStreamReader connectionRead
                = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(connectionRead);
        PrintWriter writer = new PrintWriter(connection.getOutputStream(), true);

        writer.println("You have a connection with the server! ");

        String line = reader.readLine();
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        while(line!=null){
            try {
                writer.println("you wrote: " + line);
                System.out.println("I calculate: \n" + "= " + engine.eval(line));
                System.out.println("It is the clients turn");
                line = reader.readLine();
            } catch (Exception e){
                System.out.println("There was an error in the calculation, rerun program.");
            }
        }

        reader.close();
        writer.close();
        connection.close();
    }
}
