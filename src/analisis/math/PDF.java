package analisis.math;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import static com.itextpdf.kernel.pdf.PdfName.Image;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
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
        String FOX = "logo.jpg";
        PdfWriter writer = new PdfWriter(dest);
           
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
 
        try ( // Initialize document
                Document document = new Document(pdf)) {
           Image fox = new Image(ImageDataFactory.create(FOX));

            //Add paragraph to the document
             Paragraph p = new Paragraph()
                .add(fox)
                .add(funcion)
                .add(titulo)
                .add(resultado);
        // Add Paragraph to document
        document.add(p);
        }
        
    }
}