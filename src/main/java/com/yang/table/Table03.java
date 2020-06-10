package com.yang.table;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Table03.
 * 嵌套表
 *
 * @author Yang 2020-06-04 17:40
 */
public class Table03 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);

        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Table03.pdf"));
        document.open();

        // 参数为列数
        PdfPTable table = new PdfPTable(4);
        PdfPTable nested1 = new PdfPTable(2);
        nested1.addCell("1.1");
        nested1.addCell("1.2");

        PdfPTable nested2 = new PdfPTable(1);
        nested2.addCell("2.1");
        nested2.addCell("2.2");

        for (int i = 0; i < 24; i++) {
            if (i == 1) {
                // 两列
                table.addCell(nested1);
            } else if (i == 20) {
                // 一列
                table.addCell(nested2);
            } else {
                table.addCell("cell" + i);
            }
        }
        document.add(table);

        document.close();
    }
}
