package com.codewithmotari.scims;

import net.sf.jasperreports.engine.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class JasperReportService {
    public JasperReportService() {
    }

    public File exportpdf(String filterBy, String value) throws IOException {
        String outputPath = System.getProperty("user.home") + "/reports/contactsReport.pdf";

        try {
            // Load the compiled .jasper file from src/main/resources
            InputStream jasperInput = getClass().getClassLoader().getResourceAsStream("reports/contactsReport.jrxml");

            if (jasperInput == null) {
                throw new RuntimeException("contactsReport.jasper file not found in resources/reports/");
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperInput);
            //map parameters
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("county", "lamu");
            Connection con =DBConnection.getConnection();

            // Example: using empty data source; replace with JDBC connection if needed
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,con);

            // Export to HTML or PDF — here, HTML in user home folder
            File file = new File(outputPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath);



        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to generate report", e);
        }
        File file=new File(outputPath);
        if (!file.exists()) {file.createNewFile();}
        return file;
    }
}
