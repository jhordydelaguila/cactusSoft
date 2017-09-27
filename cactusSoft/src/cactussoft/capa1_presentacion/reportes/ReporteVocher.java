package cactussoft.capa1_presentacion.reportes;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteVocher {

    public void ReporteDelPedido(int ventaid) throws SQLException, JarException, JRException {
        Map parametro = new HashMap();
        parametro.clear();
        parametro.put("ventaid", ventaid);
        Connection a = DriverManager.getConnection("jdbc:mysql://localhost/cactussoftbd", "root", "");

        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("reporteVenta.jasper");
        JasperPrint print;
        print = JasperFillManager.fillReport(jasperReport, parametro, a);
        JasperViewer ver = new JasperViewer(print, false);
        ver.setTitle("Reporte Voucher de venta");
        ver.setExtendedState(Frame.MAXIMIZED_BOTH);
        ver.setVisible(true);
    }
}
