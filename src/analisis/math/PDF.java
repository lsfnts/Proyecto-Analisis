package analisis.math;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.test.annotations.WrapToTest;

 
import java.io.File;
import java.io.IOException;
 
/**
 * Simple Hello World example.
 */
@WrapToTest
public class PDF {
 
    public static final String DEST = "results/chapter01/hello_world.pdf";
 
    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        //new PDF().createPdf(DEST);
    }

 

    public static void createPdfMod3(String dest, String resultado, String funcion, String titulo) throws IOException {
        //Initialize PDF writer
        
        PdfWriter writer = new PdfWriter(dest);
           
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
 
        // Initialize document
        Document document = new Document(pdf);
 
        //Add paragraph to the document
        document.add(new Paragraph(titulo));
     
        document.add(new Paragraph(funcion));

        document.add(new Paragraph(resultado));
        document.add(new Paragraph("."));
 
        //Close document
        document.close();
        
    }
}