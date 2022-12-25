import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static int port = 8088;

    public static void main(String[] args) {
        while (true) { // бесконечно ожидаем новых клиентов
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Сервер запущен");
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("New connection accepted");
                    final String name = in.readLine(); // принимаем строку от клиента
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort())); // отправляем ответ клиенту
                }
            } catch (IOException e) {
                System.out.println("Не могу стартовать сервер");
                e.printStackTrace();
            }
        }
    }
}
