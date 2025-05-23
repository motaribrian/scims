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

    public byte[] exportpdf(String county, String gender, String username) throws IOException {
        String outdir = System.getProperty("user.home")+"/reportsfiles/"+username;
        String outfile = outdir+"/contactsReport.pdf";
        File outdirectory = new File(outdir);
        if(!outdirectory.exists()) {outdirectory.mkdirs();}
        File outputFile = new File(outfile);
        if(!outputFile.exists()) {outputFile.createNewFile();}
        try {
            // Load the compiled .jasper file from src/main/resources
            InputStream jasperInput = getClass().getClassLoader().getResourceAsStream("reports/contactReport.jrxml");

            if (jasperInput == null) {
                throw new RuntimeException("contactsReport.jasper file not found in resources/reports/");
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperInput);
            //map parameters
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("county", county);
            parameters.put("gender", gender);
            Connection con =DBConnection.getConnection();

            //filling the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,con);

            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to generate report", e);
        }


    }
}
