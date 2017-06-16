/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.math;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

/**
 *
 * @author Luis
 */
public class Algoritmos {
	
	public static double ReglaDeSimpsonDoble(String f, double a, double b, String c, String d){
		//n=20, m=20
		double h = (a-b)/20;
		double J1=0, J2=0, J3=0;
		
		for(int i = 0; i <= 20; ++i){
			double x = a+(i*h);
			double Cx = VM.eval(c, x);
			double Dx = VM.eval(d, x);
			double HX = (Dx-Cx)/20;
			
			double K1 = VM.eval(f, x, Cx) + VM.eval(f, x, Dx);
			double K2 = 0, K3 = 0;
			
			for(int j = 0; j <= 19; ++j){
				double y = Cx + j*HX;
				double Q = VM.eval(f, x, y);
				
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
        public static void derivarFuncionX(int orderF, double xRealValue, int numDerivaciones){
            //orderF es la cantidad de variables, numDerivaciones es la cantidad de derivadas, 
            //y el xRealValue es el valor que vamos a evaluar en la funcion
          
              DerivativeStructure x = new DerivativeStructure(orderF, numDerivaciones, 0, xRealValue);
               
                DerivativeStructure x2 = x.pow(2);
                 // Basically, x --> x^2.
                System.out.println("y    = " + x2.getValue());
                System.out.println("y'   = " + x2.getPartialDerivative(1));      

        }
		
		/**
		 * 
		 * @param fun
		 * @param x
		 * @param k
		 * @return 
		 */
	public static double derivarPorDifCentrales(String fun, double x, int k){
		return deltaCentral(fun, x, 0.000001, k)/Math.pow(0.000001, k);
	}
	
		
	private static double deltaCentral(String fun, double x, double h, int k){
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
}
