package fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    //Hora

    int hora, minutos, segundos, dia, mes, ano;
    Calendar calendar = new GregorianCalendar();
    String fecha = " ";

    public String getFechaHora() {

        hora = calendar.get(Calendar.HOUR);
        minutos = calendar.get(Calendar.MINUTE);
        segundos = calendar.get(Calendar.SECOND);
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        mes = calendar.get(Calendar.MONTH);
        ano = calendar.get(Calendar.YEAR);
        fecha = dia + "/" + mes + "/" + ano + "   " + hora + ":" + minutos + ":" + segundos;
        return fecha;
    }

    public String getFecha() {
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        mes = calendar.get(Calendar.MONTH) +1;
        ano = calendar.get(Calendar.YEAR);
        if(mes < 10){
            fecha = dia + "/0" + mes + "/" + ano;
        }else{
               fecha = dia + "/" + mes + "/" + ano;
        }    
         return fecha;
    }

    public String getMes() {
        mes = calendar.get(Calendar.MONTH)+1;
        switch (mes) {
            case 1:
                fecha = "Enero";
                break;
            case 2:
                fecha = "Febrero";
                break;
            case 3:
                fecha = "Marzo";
                break;
            case 4:
                fecha = "Abril";
                break;
            case 5:
                fecha = "Mayo";
                break;
            case 6:
                fecha = "Junio";
                break;
            case 7:
                fecha = "Julio";
                break;
            case 8:
                fecha = "Agosto";
                break;
            case 9:
                fecha = "Septiembre";
                break;
            case 10:
                fecha = "Octubre";
                break;
            case 11:
                fecha = "Noviembre";
                break;
            case 12:
                fecha = "Diciembre";
                break;
        }
        return fecha;
    }

    public String getAno() {
        ano = calendar.get(Calendar.YEAR);
        fecha = "" + ano;
        return fecha;
    }

    public String getHora() {
        hora = calendar.get(Calendar.HOUR);
        minutos = calendar.get(Calendar.MINUTE);
        segundos = calendar.get(Calendar.SECOND);
        fecha = hora + ":" + minutos + ":" + segundos;
        return fecha;
    }
}
