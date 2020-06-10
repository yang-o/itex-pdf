package com.yang.table;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Table04.
 * 合并单元格
 *
 * @author Yang 2020-06-04 17:46
 */
public class Table04 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4.rotate(), 36, 36, 36, 36);

        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Table04.pdf"));
        document.open();

        // 最外层table
        PdfPTable table = new PdfPTable(4);

        float[] wid = {80f, 100f, 80f, 60f};
        table.setTotalWidth(wid);
        table.setLockedWidth(true);

        // 最外层的table的cell
        PdfPCell cell = null;

        // 嵌套的table
        PdfPTable iTable = null;

        // 嵌套的table的cell
        PdfPCell iCell = null;

        iTable = new PdfPTable(3);
        float[] iWid = {80f, 100f, 80f};
        iTable.setTotalWidth(iWid);
        iTable.setLockedWidth(true);
        iCell = new PdfPCell(new Paragraph("column 1"));
        iCell.setFixedHeight(30);
        iTable.addCell(iCell);
        iCell.setColspan(2);
        iTable.addCell(iCell);

        iCell = new PdfPCell(new Paragraph("column 2"));
        iCell.setFixedHeight(30);
        iTable.addCell(iCell);
        iTable.addCell(iCell);
        iTable.addCell(iCell);

        iCell = new PdfPCell(new Paragraph("column 3"));
        iCell.setFixedHeight(30);
        iTable.addCell(iCell);
        iTable.addCell(iCell);
        iTable.addCell(iCell);

        // 用这个table初始化外层table的cell
        cell = new PdfPCell(iTable);
        // 设置它的跨3列
        cell.setColspan(3);
        table.addCell(cell);

        iTable = new PdfPTable(1);
        float[] iWid2 = {60f};
        iTable.setTotalWidth(iWid2);
        iTable.setLockedWidth(true);
        iCell = new PdfPCell(new Paragraph("i am here"));
        iTable.addCell(iCell);
        cell = new PdfPCell(iTable);

//        cell.setFixedHeight(3 * 30);
        table.addCell(cell);
        document.add(table);

        document.close();
    }
}
