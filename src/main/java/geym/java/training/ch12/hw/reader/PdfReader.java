package geym.java.training.ch12.hw.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdfparser.PDFParser; 
import org.apache.pdfbox.util.PDFTextStripper; 

@Component("pdfReader")
public class PdfReader implements IContentReader{
	@Override
	public String readContent(String url) {
		String result = null;   
        FileInputStream is = null;   
        PDDocument document = null;   
        try {   
            is = new FileInputStream(url);   
            PDFParser parser = new PDFParser(is);   
            parser.parse();   
            document = parser.getPDDocument();   
            PDFTextStripper stripper = new PDFTextStripper();   
            result = stripper.getText(document);   
        } catch (FileNotFoundException e) {   
            e.printStackTrace();   
        } catch (IOException e) {   
            e.printStackTrace();   
        } finally {   
            if (is != null) {   
                try {is.close();}catch(IOException e){e.printStackTrace();}   
            }   
            if (document != null) {   
                try{document.close();}catch (IOException e){e.printStackTrace();}   
            }   
        }   
        return result;   
	}
}
