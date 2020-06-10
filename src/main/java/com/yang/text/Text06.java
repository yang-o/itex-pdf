package com.yang.text;

import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Text06.
 * 跳转到另一个pdf文件, 失效
 * @author Yang 2020-06-04 16:56
 */
public class Text06 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Text06.pdf"));
        document.open();

        Paragraph p1 = new Paragraph("The quick brown fox wants to");
        Chunk chunk = new Chunk(" jump over ");
        // 链接其他的文档
        chunk.setRemoteGoto("/Users/yangquan/Desktop/itext-pdf/Text05.pdf","jump");
        p1.add(chunk);
        document.add(p1);
        document.close();
    }
}
