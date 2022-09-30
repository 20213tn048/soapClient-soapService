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

    @WebMethod(operationName = "getRFC")
    public String responseMessage(@WebParam(name = "message")String name,String ap, String am,String year, String month, String date){
        String rfc="";
        rfc = ap.trim().substring(0,2);
        rfc = rfc.concat(am.trim().substring(0,1));
        rfc = rfc.concat(name.trim().substring(0,1));
        rfc = rfc.concat(year.trim().substring(2,4));
        rfc = rfc.concat(month);
        rfc = rfc.concat(date);
        final String cadena = "ABCDEFGHIJKLMNOPQRSTUVXYZ1234567890";
        final int longitud = 3;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < longitud; i++){
            double random = Math.random()*cadena.length();
            int posicion = (int) random;
            char letra = cadena.charAt(posicion);
            sb.append(letra);
        }
        rfc = rfc.concat(sb.toString());
        return rfc;
    }
    public static void main(String[] args) {
        System.out.println("Starting server...");
        Endpoint.publish("http://localhost:8080/Service", new Service());
        System.out.println("Waiting for requests...");
    }
}

