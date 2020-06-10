package com.yang.table;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Table01.
 *
 * @author Yang 2020-06-04 17:13
 */
public class Table01 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Table01.pdf"));
        document.open();

        // 参数为列数
        PdfPTable table = new PdfPTable(3);
        // 表头
        PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
        // 表头列数
        cell.setColspan(3);;
        table.addCell(cell);


        table.addCell("1.1");
        table.addCell("2.1");
        table.addCell("3.1");
        table.addCell("1.2");
        table.addCell("2.2");
        table.addCell("3.2");
        table.addCell("1.3");
        table.addCell("2.3");
        cell = new PdfPCell(new Paragraph("1.3"));
        // 设置边框颜色
        cell.setBorderColor(BaseColor.RED);
        table.addCell(cell);

        document.add(table);
        document.close();
    }

}
