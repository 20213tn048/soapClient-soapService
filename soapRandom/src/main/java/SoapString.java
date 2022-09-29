import utez.Service;
import utez.ServiceService;
import java.util.Scanner;

public class SoapString{
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        ServiceService service = new ServiceService();
        Service port = service.getServicePort();
        System.out.println("Escriba una palabra");
        String word = entrada.next();
        String message = port.getLetters(word);
        System.out.println("Palabra sin vocales: "+message);

    }
}