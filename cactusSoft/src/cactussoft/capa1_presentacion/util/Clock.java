package cactussoft.capa1_presentacion.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Clock {

    public static String hora;
    public static String minutos;
    public static String segundos;
    public static String ampm;

    public static void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date horaactual = new Date();

        calendario.setTime(horaactual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

}
