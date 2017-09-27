package cactussoft.capa5_infraestructura.parametros;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LectorDeParametros {

    public String getValorParametro(String parametro) {
        String valorParametro;
        InputStream canalDeEntrada;
        Properties propiedades = new Properties();
        try {
            canalDeEntrada = Thread.currentThread().getContextClassLoader().getResourceAsStream("cactussoft/capa5_infraestructura/parametros/Parametros.properties");
            propiedades.load(canalDeEntrada);
            valorParametro = propiedades.getProperty(parametro);
            return valorParametro;
        } catch (IOException e) {
            return null;
        }
    }
}
