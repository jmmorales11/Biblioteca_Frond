package Components;

/**
 *
 * @author ASUS TUF A15
 */

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFExporter {

    public void exportTableToPDF(JTable table, String filePath, String titleText) {
        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Título del documento
            Paragraph title = new Paragraph(titleText,
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.BOLD));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); // Espacio en blanco

            // Crear la tabla PDF con el mismo número de columnas que la JTable
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            pdfTable.setWidthPercentage(100);
            pdfTable.setSpacingBefore(10f);
            pdfTable.setSpacingAfter(10f);

            // Añadir encabezados de columna
            for (int i = 0; i < table.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(table.getColumnName(i)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }

            // Añadir filas de datos
            TableModel model = table.getModel();
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    PdfPCell cell = new PdfPCell(new Phrase(model.getValueAt(row, col).toString()));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }
            }

            // Añadir la tabla al documento
            document.add(pdfTable);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
        } finally {
            document.close();
        }
    }
}
