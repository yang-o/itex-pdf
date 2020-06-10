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
 * Table02.
 * 表的边框颜色表格列大小设置
 *
 * @author Yang 2020-06-04 17:24
 */
public class Table02 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Table02.pdf"));
        document.open();
        // 参数为列数
        PdfPTable table = new PdfPTable(3);
        // 表头
        PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
        // 表头列数
        cell.setColspan(3);
        // 设置表头居中显示
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell(cell);
        table.addCell("1.1");
        table.addCell("2.1");
        table.addCell("3.1");
        table.addCell("1.2");
        table.addCell("2.2");
        table.addCell("3.2");
        // 设置列的宽度，百分比的形式
        float[] widths = {0.3f, 0.3f, 0.3f};
        table.setWidths(widths);
        document.add(table);

        // 页面的百分比
        table.setWidthPercentage(100);
        document.add(table);

        table.setWidthPercentage(50);
        // 右对齐
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        document.add(table);

        // 左对齐
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        document.add(table);

        // 设置表格与表格之间的距离
        table.setSpacingBefore(15f);
        table.setSpacingAfter(10f);

        // 表的绝对宽度
        table.setTotalWidth(400);
        table.setLockedWidth(true);
        document.add(table);

        document.close();
    }
}
