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
    public NewtonGraphics() {
        
        setSize(600, 400);

        DataTable data = new DataTable(Double.class, Double.class);
        for (double x = -5.0; x <= 5.0; x+=0.25) {
            double y = VM.eval(Modulo1.funcion, x);
            data.add(x, y);
        }
        XYPlot plot = new XYPlot(data);
        getContentPane().add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        //plot.setLineRenderer(data, lines);
        Color color = new Color(0.0f, 0.3f, 1.0f);
        //plot.getPointRenderer(data).setColor(color);
        //plot.getLineRenderer(data).setColor(color);
    }

    //public static void main(String[] args) {
      //  NewtonGraphics frame = new NewtonGraphics();
       // frame.setVisible(true);
    //}
}
