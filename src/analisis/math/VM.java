/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.math;

import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class VM {
	
	private static final int DECIMALS=10, OUTPUT_LENGTH=20;
	
    private static final byte NUM = 0x00,
			L_PAR = 0x01,
			R_PAR = 0x02,
			SUMA = 0x03,
			RESTA = 0x04,
			MULT = 0x05,
			DIV = 0x06,
			POT = 0x07,
			SQRT = 0x08,
			SEN = 0x09,
			COS = 0x0A,
			TAN = 0x0B,
			SEC = 0x0C,
			CSC = 0x0D,
			COT = 0x0E,
			SENH = 0x0F,
			COSH = 0x10,
			TANH = 0x11,
			SECH = 0x12,
			CSCH = 0x13,
			COTH = 0x14,
			LN = 0x15,
			VAR = 0x16,
			VAR2 = 0x17,
			VAR3 = 0x18;
			
    
    private static ArrayDeque<Byte> instructions = new ArrayDeque<>();
	private static ArrayDeque<Double> valueStack = new ArrayDeque<>();
	private static ArrayDeque<Byte> instStack = new ArrayDeque<>();
	
	private static String var = "x";
	private static String var2 = "y";
	private static String var3 = "z";
	
	public static double eval(String fun, double valX){
		prepare(fun);
		return evaluarSimple(valX);
	}
	
	public static double eval(String fun, double valX, double valY){
		prepare(fun);
		return evaluarDoble(valX, valY);
	}
	
	public static double eval(String fun, double valX, double valY, double valZ){
		prepare(fun);
		return evaluarTriple(valX, valY, valZ);
	}
	
	private static double evaluarSimple(double var1Val){
		return evaluarTriple(var1Val, 0, 0);
	}
	
	private static double evaluarDoble(double var1Val, double var2Val){
		return evaluarTriple(var1Val, var2Val, 0);
	}

    private static double evaluarTriple(double var1Val, double var2Val, double var3Val){
        int size = instructions.size();
		System.out.println(instructions);
        while (!instructions.isEmpty()){
			
            byte e = instructions.pop();
			System.out.println(instructions.size());
			System.out.println(e);
            switch(e){
				case NUM:
					byte[] values = new byte[OUTPUT_LENGTH];
					for(int j = OUTPUT_LENGTH - 1; j >= 0; j--){
						values[j] = instructions.pop();
					}
					valueStack.push(bytesToDouble(values));
					break;
				case SUMA:
					double s2 = valueStack.pop();
					double s1 = valueStack.pop();
					valueStack.push(s1+s2);
					break;
				case RESTA:
					double sus = valueStack.pop();
					double min = valueStack.pop();
					valueStack.push(min-sus);
					break;
				case MULT:
					double fac2 = valueStack.pop();
					double fac1 = valueStack.pop();
					valueStack.push(fac1*fac2);
					break;
				case DIV:
					double divisor = valueStack.pop();
					double dividen = valueStack.pop();
					valueStack.push(dividen/divisor);
					break;
				case POT:
					double exp = valueStack.pop();
					double base = valueStack.pop();
					valueStack.push(Math.pow(base, exp));
					break;
				case SQRT:
					double rad = valueStack.pop();
					valueStack.push(Math.sqrt(rad));
					break;
				case COS:
					double t1 = valueStack.pop();
					valueStack.push(Math.cos(t1));
					break;
				case SEN:
					double t2 = valueStack.pop();
					valueStack.push(Math.sin(t2));
					break;
				case TAN:
					double t3 = valueStack.pop();
					valueStack.push(Math.tan(t3));
					break;
				case VAR:
					valueStack.push(var1Val);
				case VAR2:
					valueStack.push(var2Val);
				case VAR3:
					valueStack.push(var3Val);
            }
			System.out.println(valueStack);
        }
		return valueStack.pop();
    }
	
	
	private static void prepare(String f){
		f = f.replaceAll(" ", "");
		char c;
		byte[] b;
		
		int max = f.length();
		int i = 0;
		while(i < max){
			c = f.charAt(i);
			System.out.println("caracter actual: "+c);
			//si es un numero
			if(Character.isDigit(c)){
				//quitar
				String doub = takeNumber(f.substring(i));
				System.out.println("cadena eval: "+f.substring(i));
				double d = Double.parseDouble(doub);
				b = doubleToBytes(d);
				instructions.add(NUM);
				addDoubleBytes(b);
				if(d % 1 == 0){
					i += (doub.length()-2);
				}
				else i += doub.length();
			} else if (!Character.isLetter(c)){
				switch(c){
					case '(':
						instStack.push(L_PAR);
						break;
					case ')':
						while(instStack.peek() != L_PAR) {
							instructions.add(instStack.pop());
						}
						instStack.removeFirst();
						if(instStack.peek() >= SQRT){
							instructions.add(instStack.pop());
						}
						break;
					case '+':
						if(instStack.isEmpty() || instStack.peek() == L_PAR){
							instStack.push(SUMA);
						} else {
							while(instStack.peek() == SUMA || instStack.peek() == RESTA){
								instructions.add(instStack.pop());
							}
							instStack.push(SUMA);
						}
						break;
					case '-':
						if(instStack.isEmpty() || instStack.peek() == L_PAR){
							instStack.push(RESTA);
						} else {
							while(!instStack.isEmpty() && (instStack.peek() == SUMA || instStack.peek() == RESTA)){
								instructions.add(instStack.pop());
							}
							instStack.push(RESTA);
						}
						break;
					case '*':
						if(instStack.isEmpty() || instStack.peek() == L_PAR){
							instStack.push(MULT);
						} else {
							while (instStack.peek() == SUMA || instStack.peek() == RESTA ||
									instStack.peek() == MULT || instStack.peek() == DIV){
								instructions.add(instStack.pop());
							}
							instStack.push(MULT);
						}
						break;
					case '/':
						if(instStack.isEmpty() || instStack.peek() == L_PAR){
							instStack.push(DIV);
						} else {
							while (instStack.peek() == SUMA || instStack.peek() == RESTA ||
									instStack.peek() == MULT || instStack.peek() == DIV){
								instructions.add(instStack.pop());
							}
							instStack.push(DIV);
						}
						break;
					case '^':
						if(instStack.isEmpty() || instStack.peek() == L_PAR){
							instStack.push(POT);
						} else {
							while (instStack.peek() == SUMA || instStack.peek() == RESTA ||
									instStack.peek() == MULT || instStack.peek() == DIV ||
									instStack.peek() == POT){
								instructions.add(instStack.pop());
							}
							instStack.push(DIV);
						}
						break;
				}
				System.out.println("instStack: "+instStack);
				++i;
			} else {
				i += takeFun(f.substring(i));
			}
		}
		while(!instStack.isEmpty()){
			instructions.add(instStack.pop());
		}
	}
	
	private static byte [] doubleToBytes(double d){
		byte[] output = new byte[OUTPUT_LENGTH];
		StringBuilder input = new StringBuilder(OUTPUT_LENGTH);

        // separar parte entera y decimal
        String[] split = Double.toString(d).split("\\.");

        String firstPart = split[0];
        // recrear la parte entera con ceros a la izquierda
		for (int i = (OUTPUT_LENGTH-DECIMALS)-1; i >= firstPart.length(); --i) {
				input.append(0);
		}
        for (int i = 0; i < firstPart.length(); ++i) {
			input.append(firstPart.charAt(i));
        }

        // parte decimal
        if (split.length > 1) {
            String secondPart = split[1];
            for (int i = 0; i < DECIMALS; ++i) {
				if (i >= secondPart.length()) {
					input.append(0);
				} else {
				input.append(secondPart.charAt(i));				
				}
            }
        }
		for(int i = input.length() - 1; i >= 0; i--) {{
				output[i] = Byte.valueOf(input.substring(i,i+1));
			}
		}

		return output;
	}
	
	private static double bytesToDouble(byte[] b){
		StringBuilder builder = new StringBuilder(OUTPUT_LENGTH);
		boolean negative = false;
		for(int i = OUTPUT_LENGTH-1; i >= 0; --i){
			
			if(b[i] == -1){
				negative = true;
				continue;
			}
			
			builder.append(b[i]);
			if(i==10) builder.append(".");
		}
		if(negative) return -Double.valueOf(builder.toString());
		else return Double.valueOf(builder.toString());
	}
	
	private static void addDoubleBytes(byte[] b){
		for(int i = 0; i <OUTPUT_LENGTH; ++i){
			instructions.add(b[i]);
		}
	}
	
	/**
 * añane la funcion al stack y retorna la longitud para continuar iterando.
 *
 * @param ...
 * @return int lenght
 */
	private static int takeFun(String s){
		Scanner scanner = new Scanner(s);
		scanner.useDelimiter("[0-9]|(\\(|\\)|\\*|\\+|\\-|\\=|\\[|\\]|\\^|\\/)");
		String s1 = "";
		if (scanner.hasNext()) {
			s1 = scanner.next();
			if(s1.equals(var)){
				instructions.add(VAR);
			} else if(s1.equals(var2)){
				instructions.add(VAR2);
			} else{
				switch(s1){
					case "sqrt":
						instStack.push(SQRT);
						break;
					case "cos":
						instStack.push(COS);
						break;
					case "sin": case "sen":
						instStack.push(SEN);
						break;
					case "tan":
						instStack.push(TAN);
						break;
				}
			}
		}
		scanner.close();
		return s1.length();
	}
	private static String takeNumber(String s){
		// create a new scanner with the specified String Object
		Scanner scanner = new Scanner(s);
		scanner.useDelimiter("[a-zA-Z]|(\\(|\\)|\\*|\\+|\\-|\\=|\\[|\\]|\\^|\\/)");

		// use US locale to be able to identify doubles in the string
		scanner.useLocale(Locale.US);
		// find the next double token and print it
		// loop for the whole scanner
		// if the next is a double, print found and the double
		double d=0;
			// if the next is a double, print found and the double
		if (scanner.hasNextDouble()) {
			d =  scanner.nextDouble();
		}

		scanner.close();
		return String.valueOf(d);
	}
}
