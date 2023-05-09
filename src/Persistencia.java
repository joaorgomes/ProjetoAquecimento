import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Persistencia {
	private XStream xStream = new XStream(new DomDriver("UTF-8"));

	public void salvarCentral(CentralDeInformacoes central, String nomeDoArquivo) throws Exception {
		File arquivo = new File(nomeDoArquivo);
		arquivo.createNewFile();
		PrintWriter pw = new PrintWriter(arquivo);
		String xml = "<xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		xml = xStream.toXML(central);
		pw.print(xml);
		pw.close();
	}
	public Persistencia(){
		xStream.addPermission(AnyTypePermission.ANY);
	}
	public CentralDeInformacoes recuperarCentral(String nomeArquivo){
		File novoArquivo = new File(nomeArquivo);
		
			try {
				if(novoArquivo.exists()) {
					FileInputStream fis = new FileInputStream(novoArquivo);
					return (CentralDeInformacoes) xStream.fromXML(novoArquivo);
				}	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			return new CentralDeInformacoes();
	}	
}

