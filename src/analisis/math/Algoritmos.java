/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.math;

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
}