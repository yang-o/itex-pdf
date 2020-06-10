package com.yang.table;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Table05.
 * 单元格内数据显示实例
 *
 * @author Yang 2020-06-04 18:04
 */
public class Table05 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Table05.pdf"));
        document.open();

        PdfPTable table = new PdfPTable(2);
        PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 2"));
        cell.setColspan(2);
        table.addCell(cell);

        Paragraph p = new Paragraph("jkdajl jadjalksjdlka djlaksjdljas  ldjaksjdlkajsdlj jdlaksjdkja jldajksdjal  jdlajsdk ");
        table.addCell("default alignment");
        cell = new PdfPCell(p);
        table.addCell(cell);

        table.addCell("centered alignment");
        cell = new PdfPCell(p);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        table.addCell("right alignment");
        cell = new PdfPCell(p);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);

        table.addCell("lelt alignment");
        cell = new PdfPCell(p);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED_ALL);
        table.addCell(cell);
        table.addCell("jdjajdajdkakjdkajdkajdkajdka");

        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        // middle top
        table.addCell("bottom");

        document.add(table);
        document.close();
    }
}
