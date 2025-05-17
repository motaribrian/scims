package com.codewithmotari.scims;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class PdfBoxx {
    private static PDDocument document;
    public PdfBoxx() throws IOException {
        document=new PDDocument();
        document.save("/home/ztl/NetBeansProjects/Motari_Internship/scims");
        document.close();
    }
    public static PDDocument getPdf(){
        PDPage page=new PDPage();
        document.addPage(page);
        return null;
    }
}
