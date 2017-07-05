/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.math;
import java.text.DecimalFormat;
import static analisis.gui.mod1.Modulo1.modelo;
/**
 *
 * @author Luis
 */
public class Algoritmos {
    public static DecimalFormat df = new DecimalFormat("#.000000");
    public static boolean newton = false;
    public static double raiz;
    public static Object []object = new Object[8];
    public static int iteraciones;
    public static Double[] apr;
    public static boolean abierto =false;
        
        

    public static String MetodoDeNewton(String funcion, double tolerancia, int iterations, double pini) throws InvalidInput{
        iteraciones=0;
        double pinicial = pini; //p0
        double pgorro = 0; //p1
        double error;
        int t=200;
        int s=1;
        apr = new Double[t];
        apr[0]=pinicial;
        
        
        while(iteraciones<iterations){
            
            pgorro = (pinicial - ((VM.eval(funcion, pinicial))/(derivar(funcion,pinicial,1))));
            apr[s]=pgorro;
            s++;
            
      
            error = Math.abs(pgorro - pinicial) ;
            //pgorro = (pinicial - (((Math.pow(pinicial,3))+ (3*pinicial)+1)/((3*(Math.pow(pinicial,2)))+3)));
            if (error< tolerancia){
                iteraciones ++;
                newton = true;
                object[0]=iteraciones;
                object[1]=pinicial;
                object[2]=pgorro;
                object[3]=error;
                modelo.addRow(object);
                raiz=pgorro;
                
                return df.format(pgorro);
                //System.out.println("EXITO "+pgorro);
                
            }else{
                iteraciones++;
                object[0]=iteraciones;
                object[1]=pinicial;
                object[2]=pgorro;
                object[3]=error;
                modelo.addRow(object);
                pinicial = pgorro;
                
            }
        }
        
        newton = false;
        return df.format(pgorro);
       //System.out.println("fallo  "+pgorro+" iteraciones  "+ iteraciones);
    }
	
    public static String MetodoDeNewton(String funcion, double tolerancia, int iterations) throws InvalidInput{
        iteraciones=0;
        double pinicial = 1; //p0
        double pgorro = 0; //p1
        double error;
        int t=200;
        int s=1;
        apr = new Double[t];
        apr[0]=pinicial;
        
        
        while(iteraciones<iterations){
            
            pgorro = (pinicial - ((VM.eval(funcion, pinicial))/(derivar(funcion,pinicial,1))));
            apr[s]=pgorro;
            s++;
            
      
            error = Math.abs(pgorro - pinicial) ;
            //pgorro = (pinicial - (((Math.pow(pinicial,3))+ (3*pinicial)+1)/((3*(Math.pow(pinicial,2)))+3)));
            if (error< tolerancia){
                iteraciones ++;
                newton = true;
                object[0]=iteraciones;
                object[1]=pinicial;
                object[2]=pgorro;
                object[3]=error;
                modelo.addRow(object);
                raiz=pgorro;
                
                return df.format(pgorro);
                //System.out.println("EXITO "+pgorro);
                
            }else{
                iteraciones++;
                object[0]=iteraciones;
                object[1]=pinicial;
                object[2]=pgorro;
                object[3]=error;
                modelo.addRow(object);
                pinicial = pgorro;
                
            }
        }
        
        newton = false;
        return df.format(pgorro);
       //System.out.println("fallo  "+pgorro+" iteraciones  "+ iteraciones);
    }
	
	public static double ReglaDeSimpsonTriple(String f, double a, double b, String var1,
			String c, String d,String var2, String s, String t,String var3) throws InvalidInput{
		//n=10, m=10, p=10
		long startTime =System.currentTimeMillis();
		double h = (b-a)/20;
		double J1=0, J2=0, J3=0;
		
		//variables integral externa
		double x;
		double Cx;
		double Dx;
		double HX;
		
		//varibales integral intermedia
		double y;
		double Sy;
		double Ty;
		double HY;
		
		//variables integral interna
		double z;
		double R;
		
		for(int i = 0; i <= 20; ++i){
			x = a+(i*h);
			Cx = VM.eval(c, x, var1);
			Dx = VM.eval(d, x, var1);
			HX = (Dx-Cx)/20;
			
			double K1 =0, K2 = 0, K3 = 0;
			
			for(int j = 0; j <= 20; ++j){
				y = Cx + j*HX;
				Sy = VM.eval(s, x, var1, y, var2);
				Ty = VM.eval(t, x, var1, y, var2);
				HY = (Ty-Sy)/20;
				
				double S1 = 0, S2 = 0, S3 = 0;
				
				for(int k = 0; k <= 20; ++k){
					z = Sy + k*HY;
					R = VM.eval(f, x, var1, y, var2, z, var3);
					if(k == 0 || k == 20) S1 += R;
					else if(k%2 == 0) S2 += R;
					else S3 += R;
				}
				
				double Q = (S1 + 2*S2 + 4*S3)*HY/3;
				
				if(i == 0 || i == 20) K1 += Q;
				else if(j%2 == 0) K2 += Q;
				else K3 += Q;
			}
			
			double L = (K1 + 2*K2 + 4*K3)*HX/3;
			
			if(i == 0 || i == 20) J1 += L;
			else if (i % 2 == 0) J2 += L;
			else J3 += L;
		}
		System.out.println(System.currentTimeMillis()-startTime);
		return h*(J1 + 2*J2 + 4*J3)/3;
	}
	
	public static double ReglaDeSimpsonDoble(String f, double a, double b, String var1,
			String c, String d, String var2) throws InvalidInput{
		//n=20, m=20
		double h = (b-a)/20;
		double J1=0, J2=0, J3=0;
		
		for(int i = 0; i <= 20; ++i){
			double x = a+(i*h);
			double Cx = VM.eval(c, x, var1);
			double Dx = VM.eval(d, x, var1);
			double HX = (Dx-Cx)/20;
			
			double K1 = VM.eval(f, x, var1, Cx, var2) + VM.eval(f, x, var1, Dx, var2);
			double K2 = 0, K3 = 0;
			
			for(int j = 1; j < 20; ++j){
				double y = Cx + j*HX;
				double Q = VM.eval(f, x, var1, y, var2);
				
				if(j%2 == 0) K2 += Q;
				else K3 += Q;
			}
			
			double L = (K1 + 2*K2 + 4*K3)*HX/3;
			
			if(i == 0 || i == 20) J1 += L;
			else if (i % 2 == 0) J2 += L;
			else J3 += L;
		}
		
		return h*(J1 + 2*J2 + 4*J3)/3;
	}
	
	public static double ReglaDeSimpsonSimple(String f, double a, double b, String var) throws InvalidInput{
		//n=10
		double h = (b-a)/20;
		double K1=0, K2=0, K3=0;
		
		double x;
		for(int i = 0; i <= 20; ++i){
			x = a+(i*h);
			
			
			if(i == 0 || i == 20) K1 += VM.eval(f, x, var);
			else if (i % 2 == 0) K2 += VM.eval(f, x, var);
			else K3 += VM.eval(f, x, var);
		}
		
		return h*(K1 + 2*K2 + 4*K3)/3;
	}
	
      
		
		/**
		 * Derivar por diferencias centrales
		 * 
		 * @param fun string que representa la funcion
		 * @param x punto a evaluar
		 * @param k grado de la derivada
		 * @return 
		 */
	public static double derivar(String fun, double x, int k) throws InvalidInput{
		return deltaCentral(fun, x, 0.000001, k)/Math.pow(0.000001, k);
	}
	
		
	public static double deltaCentral(String fun, double x, double h, int k) throws InvalidInput{
		double deltaY=0;
		for (int i = 0; i <=k;++i){
			if(i%2==0){
				deltaY += comb(k, i)*VM.eval(fun, x + (h*((k/2)-i)) );
			} else {
				deltaY -= comb(k, i)*VM.eval(fun, x+ (h*((k/2)-i)));
			}
		}
		
		return deltaY;
	}
	
	private static int comb(int m, int n){
		int factorialmn = 1, factorialn = 1, factorialm = 1;
		//Esto saca el factorial de m
        for (int i = m; i > 0; i--) {
            if (m == 0 || m == 1) {
                factorialm = 1;
                break;
            }
            factorialm = i * factorialm;
        }

        //Esto saca el factorial de n
        for (int i = n; i > 0; i--) {
            if (n == 0 || n == 1) {
                factorialn = 1;
                break;
            }
            factorialn = i * factorialn;
        }

        //Esto saca el factorial de n-m:
        for (int i = m - n; i > 0; i--) {
            if (m - n == 0 || m - n == 1) {
                factorialmn = 1;
                break;
            }
            factorialmn = i * factorialmn;
        }

        //Esto calcula la combinatoria de n & m:
        return (factorialm / (factorialn * factorialmn));

	}
        public static String rectasTangentes(String funcion, Double valorinicial) throws InvalidInput{
               double ordenada=(VM.eval(funcion, valorinicial));
               double pendiente=(derivar(funcion,valorinicial,1));
               double abcisa= pendiente*(-valorinicial);
               
               if(abcisa>0 && pendiente>0){
                   
                   return  String.valueOf(ordenada)+"+"+String.valueOf(pendiente)+"*x+"+String.valueOf(abcisa);
               
               }
               else if(abcisa>0){
                    return String.valueOf(ordenada)+"+"+String.valueOf(pendiente)+"*x+"+String.valueOf(abcisa);
               }
               else{
                    return String.valueOf(ordenada)+"+"+String.valueOf(pendiente)+"*x"+String.valueOf(abcisa);
               } 

        }
	
	public static double area(String fun, double a, double b, String var) throws InvalidInput{
		double raiz1 = Double.valueOf(MetodoDeNewton(fun, 0.0001, 30, a));
		double raiz2 = Double.valueOf(MetodoDeNewton(fun, 0.0001, 30, b));
		if(Integer.signum((Double.compare(raiz1, a)*Double.compare(raiz1, b))) < 0 ||
				Integer.signum((Double.compare(raiz2, a)*Double.compare(raiz2, b))) < 0){
			return Math.abs(ReglaDeSimpsonSimple(fun, a, raiz1, var))+ Math.abs(ReglaDeSimpsonSimple(fun, raiz1, b, var))+
					Math.abs(ReglaDeSimpsonSimple(fun, a, raiz2, var))+ Math.abs(ReglaDeSimpsonSimple(fun, raiz2, b, var));
		} else{
			return Math.abs(ReglaDeSimpsonSimple(fun, a, raiz1, var));
		}
	}
		
	static public final double PI = 3.1415926535897932;
}
