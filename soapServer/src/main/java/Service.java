import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Random;

@WebService(name ="Service", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Service {
    @WebMethod(operationName = "aleatoryNumber")
    public String responseMessage(@WebParam(name = "number") Integer number) {
        Random random = new Random();
        int aux = random.nextInt(3);
        if (number == aux){
            return "Correcto";
        }else{
            return "Prueba otra vez.Número aleatorio: "+ aux;
        }
    }

    @WebMethod(operationName = "getLetters")
    public String responseMessage(@WebParam(name = "message")String word){
        if(word == null){
            return "Ingresa una palabra para continuar";
        }else{
            return  word.replaceAll("aeiou",word);
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting server...");
        Endpoint.publish("http://localhost:8081/Service", new Service());
        System.out.println("Waiting for requests...");
    }
}

