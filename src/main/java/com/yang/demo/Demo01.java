package com.yang.demo;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * PdfDemo01.
 *
 * @author Yang 2020-06-04 18:36
 */
public class Demo01 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4, 10, 10, 36, 36);
        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Demo01.pdf"));
        document.open();
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 18, Font.BOLD);
        Font fontData = new Font(bfChinese, 12, Font.UNDEFINED);
        Font fontTable = new Font(bfChinese, 10, Font.NORMAL);
        Font fontTableHeader = new Font(bfChinese, 8, Font.BOLD);

        Paragraph title = new Paragraph("客户报价单", fontChinese);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        PdfPTable tableHeader = new PdfPTable(2);
        PdfPCell cell = new PdfPCell(new Paragraph("客户编号：" + "03160564463216613", fontData));
        cell.setBorder(Rectangle.NO_BORDER);
        tableHeader.addCell(cell);

        cell = new PdfPCell(new Paragraph("报价单编号：" + "03160564463216613", fontData));
        cell.setBorder(Rectangle.NO_BORDER);
        tableHeader.addCell(cell);

        cell = new PdfPCell(new Paragraph("客户名称：" + "北京龙辉鞋业", fontData));
        cell.setBorder(Rectangle.NO_BORDER);
        tableHeader.addCell(cell);

        cell = new PdfPCell(new Paragraph("销售隶属：" + "03160564463216613", fontData));
        cell.setBorder(Rectangle.NO_BORDER);
        tableHeader.addCell(cell);

        cell = new PdfPCell(new Paragraph("电话：" + "024-265469846", fontData));
        cell.setBorder(Rectangle.NO_BORDER);
        tableHeader.addCell(cell);

        cell = new PdfPCell(new Paragraph("订单时间：" + "2020-06-04", fontData));
        cell.setBorder(Rectangle.NO_BORDER);

        // 设置表上边的距离
        tableHeader.setSpacingBefore(30f);
        tableHeader.addCell(cell);
        // 设置列的宽度， 百分比的形式
        float[] widths = {0.5f, 0.5f};
        tableHeader.setWidths(widths);
        tableHeader.setSpacingBefore(15f);
        document.add(tableHeader);

        PdfPTable table = new PdfPTable(7);
        cell = new PdfPCell(new Paragraph("商品编号：", fontTableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("商品名称：", fontTableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("数量：", fontTableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("单位：", fontTableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("折扣：", fontTableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("公式：", fontTableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell.setFixedHeight(20f);
        for (int i = 0; i <= 100; i++) {
            cell = new PdfPCell(new Paragraph("205464616543165", fontTable));
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("笔记本电脑", fontTable));
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("134", fontTable));
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("台", fontTable));
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("5000", fontTable));
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("80%", fontTable));
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("aefwa", fontTable));
            table.addCell(cell);

            // 每页都设置表头
            table.setHeaderRows(1);
        }

        float[] width = {0.2f, 0.2f, 0.1f, 0.1f, 0.1f, 0.1f, 0.2f};
        table.setWidths(width);

        // 设置表上边的距离
        table.setSpacingBefore(15f);
        document.add(table);

        PdfPTable tableBottom = new PdfPTable(2);
        cell = new PdfPCell(new Paragraph("销售人：" + "王萍", fontData));
        cell.setBorder(Rectangle.NO_BORDER);
        tableBottom.addCell(cell);

        cell = new PdfPCell(new Paragraph("销售编号：" + "03160564603216613", fontData));
        cell.setBorder(Rectangle.NO_BORDER);
        tableBottom.addCell(cell);

        cell = new PdfPCell(new Paragraph("最近修改人：" + "王萍", fontData));
        cell.setBorder(Rectangle.NO_BORDER);
        tableBottom.addCell(cell);

        cell = new PdfPCell(new Paragraph("客户类型：" + "服务", fontData));
        cell.setBorder(Rectangle.NO_BORDER);
        tableBottom.addCell(cell);

        cell = new PdfPCell(new Paragraph("业务归属人：" + "王萍", fontData));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(2);
        tableBottom.addCell(cell);

        cell = new PdfPCell(new Paragraph("备注：" + "相信自己，就是要'自信'，就是面对困难、挫折和新的挑战不要这幅，不要胆怯。面对困难、挫折、挑战只要你肯相信自己，不断努力的付出，哪怕你现在的人生是从零开始，你都可以做得到", fontData));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(2);
        tableBottom.addCell(cell);

        tableBottom.setSpacingBefore(15f);
        document.add(tableBottom);
        document.close();
    }
}
