import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static String ip = "127.0.0.1";
    public static int port = 8088;

    public static void main(String[] args) {
        try (Socket socket = new Socket(ip, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ваше имя");
            out.println(scanner.nextLine()); // отправляем имя серверу
            System.out.println(in.readLine()); // выводим на экран ответ сервера
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
