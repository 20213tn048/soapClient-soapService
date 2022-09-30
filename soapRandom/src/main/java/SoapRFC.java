import utez.Service;
import utez.ServiceService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class SoapRFC {
    static Scanner entrada = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    static Calendar calendar = new GregorianCalendar();

    public static void main(String[] args) {
        String date,month,year;
        int dia=0,mes=0,anio=0;
        ServiceService service = new ServiceService();
        Service port = service.getServicePort();
        System.out.println("Rellene todos los campos para continuar");
        System.out.println("Nombre");
        String nombre = entrada.next();
        System.out.println("Apellido Paterno");
        String ap = entrada.next();
        System.out.println("Apellido Materno");
        String am = entrada.next();
        do{
            System.out.println("Día de nacimiento");
            date = entrada.next();
            if(!isNumber(date)){
                System.out.println("Escriba el número del día en que nació");
            }else{
                dia = Integer.parseInt(date);
            }
        }while (!isNumber(date));
        do{
            System.out.println("Mes de nacimiento");
            month = entrada.next();
            if(!isNumber(month)){
                System.out.println("Escriba el número del mes en que nació");
            }else{
                mes = Integer.parseInt(month);
            }
        }while (!isNumber(month));
        do{
            System.out.println("Año de nacimiento");
            year = entrada.next();
            if(!isNumber(year)){
                System.out.println("Escriba el número del año en que nació");
            }else{
                anio = Integer.parseInt(year);
            }
        }while (!isNumber(year));
        setDateCalendar(dia,mes,anio);
        Date born = getDateCalendar();
        String message = port.getRFC(nombre,ap,am,year,month,date);
        System.out.println("Tu RFC es: "+message);
    }
    public static boolean isNumber(String aux){
        try{
            int num = Integer.parseInt(aux);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static String DateAString(Date fecha){
        return sdf.format(fecha);
    }
    public static void setDateCalendar(int date,int month,int year){
        calendar.set(year,month,date);
    }
    public static Date getDateCalendar(){
        return calendar.getTime();
    }

}
