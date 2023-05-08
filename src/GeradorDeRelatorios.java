import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorDeRelatorios {

	public static void obterRelatorioDoMes(Month mes, CentralDeInformacoes central) {
		ArrayList<Evento> eventos = central.getTodosOsEventos();
		Document doc = new Document(PageSize.A4);
		try {
			OutputStream os = new FileOutputStream("relatorio.pdf");
			PdfWriter.getInstance(doc, os);
			doc.open();
			doc.add(new Paragraph("Segue lista de eventos contratados para "+mes));
			boolean condicao = true;
			for (Evento relatorioEvento : eventos) {
				if (mes.equals(relatorioEvento.getData().getMonth()) && relatorioEvento.isFoiContratado()) {
					doc.add(new Paragraph(
							relatorioEvento.getNomeEvento() + " - " + relatorioEvento.getClienteAssociado()));
					condicao = false;

				}
			}
			if (condicao) {
				doc.add(new Paragraph("-Nao ha eventos contratados para o mes "));

			}

			doc.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {

			e.printStackTrace();
		}
	}

}