package cactussoft.capa1_presentacion.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Fecha {

    public static String fechaActualString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(new java.util.Date());
    }
}
