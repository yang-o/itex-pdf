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
 * Table06.
 *
 * @author Yang 2020-06-05 00:37
 */
public class Table06 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Table06.pdf"));
        document.open();

        PdfPTable table = new PdfPTable(1);

        PdfPCell cell = new PdfPCell(new Paragraph("ALIGN_UNDEFINED"));
        cell.setHorizontalAlignment(-1);
        cell.setFixedHeight(40);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("ALIGN_LEFT"));
        cell.setHorizontalAlignment(0);
        cell.setFixedHeight(40);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("ALIGN_CENTER"));
        cell.setHorizontalAlignment(1);
        cell.setFixedHeight(40);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("ALIGN_RIGHT"));
        cell.setHorizontalAlignment(2);
        cell.setFixedHeight(40);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("ALIGN_JUSTIFIED"));
        cell.setHorizontalAlignment(3);
        cell.setFixedHeight(40);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("ALIGN_TOP"));
        cell.setHorizontalAlignment(4);
        cell.setFixedHeight(40);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("ALIGN_MIDDLE"));
        cell.setHorizontalAlignment(5);
        cell.setFixedHeight(40);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("ALIGN_BOTTOM"));
        cell.setHorizontalAlignment(6);
        cell.setFixedHeight(40);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("ALIGN_BASELINE"));
        cell.setHorizontalAlignment(7);
        cell.setFixedHeight(40);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("ALIGN_JUSTIFIED_ALL"));
        cell.setHorizontalAlignment(8);
        cell.setFixedHeight(40);
        table.addCell(cell);


        document.add(table);
        document.close();

    }
}
