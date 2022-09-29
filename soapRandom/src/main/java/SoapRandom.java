import utez.Service;
import utez.ServiceService;
import java.util.Scanner;

public class SoapRandom {
    static Scanner entrada = new Scanner (System.in);
    public static void main(String[] args) {
        ServiceService service = new ServiceService();
        Service port = service.getServicePort();
        System.out.println("Escriba el número que creé que se generó aleatoriamente");
        Integer num = entrada.nextInt();
        String message = port.aleatoryNumber(num);
            System.out.println(message);
    }
}
