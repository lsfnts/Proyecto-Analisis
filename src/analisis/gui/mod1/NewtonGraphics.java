/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.gui.mod1;

/**
 *
 * @author Franco
 */
import analisis.math.Algoritmos;
import analisis.math.InvalidInput;
import analisis.math.VM;
import java.awt.Color;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;


public class NewtonGraphics extends JFrame {
    public NewtonGraphics() throws InvalidInput {
        
        setSize(600, 400);

        DataTable dataX = new DataTable(Double.class, Double.class);
        for (double x = -10.0; x <= 10.0; x+=1) {
            double y = VM.eval(Modulo1.funcion, x);
            dataX.add(x, y);
        }
        //XYPlot plotX = new XYPlot(dataX);
        
        DataTable dataY = new DataTable(Double.class, Double.class);
        for (double y = -50.0; y <= 50.0; y+=10) {
            double x = Algoritmos.raiz;
            dataY.add(x, y);
        }
        
        int values = 0;
        for(int z =0; z<Algoritmos.apr.length; z++){
            if(Algoritmos.apr[z] != null){
                values++;
            }
        }
        
        DataTable dataP = new DataTable(Double.class, Double.class);
        
        for(int i = 0; i<values; i++){
            
            for (double y = -50.0; y <= 50.0; y+=3) {
            double x = Algoritmos.apr[i];
            dataP.add(x, y);
        }
        
        }
        
        XYPlot plot = new XYPlot(dataX,dataY,dataP);
        getContentPane().add(new InteractivePanel(plot));
        
                
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderer(dataX, lines);
        plot.setLineRenderer(dataY, lines);
        Color color = new Color(0.0f, 0.3f, 1.0f);
        plot.getPointRenderer(dataX).setColor(color);
        plot.getLineRenderer(dataX).setColor(color);
    }

    //public static void main(String[] args) {
      //  NewtonGraphics frame = new NewtonGraphics();
       // frame.setVisible(true);
    //}
}
