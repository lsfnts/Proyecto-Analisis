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
			VAR3 = 0x18,
			NEG = 0x19,
			PI = 0x1A;
			
    
    private static ArrayDeque<Byte> instructions = new ArrayDeque<>();
	private static ArrayDeque<Double> valueStack = new ArrayDeque<>();
	private static ArrayDeque<Byte> instStack = new ArrayDeque<>();
	
	private static String var1 = "";
	private static String var2 = "";
	private static String var3 = "";
	
	/**
	 * 
	 * @param fun función a evaluar
	 * @param valX valor de la variable
	 * @param var1 nombre de la variable variable
	 * @return 
	 */
	public static double eval(String fun, double valX, String var1) throws InvalidInput{
		VM.var1 = var1;
		prepare(fun);
		return evaluar(valX, 0, 0);
	}
	
	/**
	 * 
	 * @param fun función a evaluar
	 * @param valX valor de primera variable
	 * @param var1 nombre de primera variable
	 * @param valY valor de segunda variable
	 * @param var2 nombre de segunda variable
	 * @return 
	 */
	public static double eval(String fun, double valX, String var1, double valY, String var2) throws InvalidInput{
		VM.var1 = var1;
		VM.var2 = var2;
		prepare(fun);
		return evaluar(valX, valY, 0);
	}
	
	/**
	 * 
	 * @param fun función a evaluar
	 * @param valX valor de primera variable
	 * @param var1 nombre de primera variable
	 * @param valY valor de segunda variable
	 * @param var2 nombre de segunda variable
	 * @param valZ valor de tercera variable
	 * @param var3 nombre de tercera variable
	 * @return 
	 */
	public static double eval(String fun, double valX, String var1, double valY,
			String var2, double valZ, String var3) throws InvalidInput{
		VM.var1 = var1;
		VM.var2 = var2;
		VM.var3 = var3;
		prepare(fun);
		return evaluar(valX, valY, valZ);
	}
	
	/**
	 * 
	 * @param fun cadena que representa la funcion ej. "2*x+3"
	 * @param valX punto a evaluar (valor de x)
	 * @return 
	 */
	public static double eval(String fun, double valX) throws InvalidInput{
		resetVar();
		prepare(fun);
		return evaluar(valX, 0, 0);
	}
	
	/**
	 * 
	 * @param fun cadena que representa la funcion ej. "2*x+3-y"
	 * @param valX punto a evaluar (valor de x)
	 * @param valY punto a evaluar (valor de y)
	 * @return 
	 */
	public static double eval(String fun, double valX, double valY) throws InvalidInput{
		resetVar();
		prepare(fun);
		return evaluar(valX, valY, 0);
	}
	
	/**
	 * 
	 * @param fun cadena que representa la funcion ej. "2*x+3-y^z"
	 * @param valX punto a evaluar (valor de x)
	 * @param valY punto a evaluar (valor de y)
	 * @param valZ punto a evaluar (valor de z)
	 * @return 
	 */
	public static double eval(String fun, double valX, double valY, double valZ) throws InvalidInput{
		resetVar();
		prepare(fun);
		return evaluar(valX, valY, valZ);
	}
	
	private static void resetVar(){
		VM.var1 = "x";
		VM.var2 = "y";
		VM.var3 = "z";
	}
	
	/**
	 * evalua la expresión guardada y devuelve el resultado
	 * @param var1Val
	 * @param var2Val
	 * @param var3Val
	 * @return 
	 */
    private static double evaluar(double var1Val, double var2Val, double var3Val){
		//recorre el stack hasta que no encuentre mas instrucciones
        while (!instructions.isEmpty()){
			//toma la primera instrucción y realiza la accion apropiada
            byte e = instructions.pop();
            switch(e){
				//indica que los siguientes bytes representan un numero
				//toma su valor y lo agrega al stack de valores
				case NUM:
					byte[] values = new byte[OUTPUT_LENGTH];
					for(int j = OUTPUT_LENGTH - 1; j >= 0; j--){
						values[j] = instructions.pop();
					}
					valueStack.push(bytesToDouble(values));
					break;
				//toma los primeros valores del stack de valores
				// y realiza la operación respectiva
				case SUMA:
					double s2 = valueStack.pop();
					double s1 = valueStack.pop();
					valueStack.push(s1+s2);
					break;
				case RESTA:
					double sus = valueStack.pop();
					double min = valueStack.pop();
					valueStack.push(min-sus);
				case NEG:
					double neg = valueStack.pop();
					valueStack.push(-neg);
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
					if(exp%1 == 0) valueStack.push(Algoritmos.intPow(base, (int) exp));
					else valueStack.push(Math.pow(base, exp));
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
				case SEC:
					double t4 = valueStack.pop();
					valueStack.push(1/Math.cos(t4));
					break;
				case CSC:
					double t5 = valueStack.pop();
					valueStack.push(1/Math.sin(t5));
					break;
				case COT:
					double t6 = valueStack.pop();
					valueStack.push(Math.cos(t6)/Math.sin(t6));
					break;
				case SENH:
					double h1 = valueStack.pop();
					valueStack.push(Math.sinh(h1));
					break;
				case COSH:
					double h2 = valueStack.pop();
					valueStack.push(Math.cosh(h2));
					break;
				case TANH:
					double h3 = valueStack.pop();
					valueStack.push(Math.sinh(h3)/Math.cosh(h3));
					break;
				case SECH:
					double h4 = valueStack.pop();
					valueStack.push(1/Math.cosh(h4));
					break;
				case CSCH:
					double h5 = valueStack.pop();
					valueStack.push(1/Math.sinh(h5));
					break;
				case COTH:
					double h6 = valueStack.pop();
					valueStack.push(Math.cosh(h6)/Math.sinh(h6));
					break;
				case LN:
					double a = valueStack.pop();
					valueStack.push(Math.log(a));
					break;
				case PI:
					valueStack.push(Algoritmos.PI);
				//indica que es una variable, guarda en el stack el valor
				case VAR:
					valueStack.push(var1Val);
					break;
				case VAR2:
					valueStack.push(var2Val);
					break;
				case VAR3:
					valueStack.push(var3Val);
					break;
            }
        }
		return valueStack.pop();
    }
	
	/**
	 * recibe una cadena que representa una función y prepara el stack con las
	 * operaciones y valores contenidos
	 * @param f 
	 */
	private static void prepare(String f) throws InvalidInput{
		f = f.replaceAll(" ", "").toLowerCase();
		char c;
		byte[] b;
		
		int max = f.length();
		int i = 0;
		boolean lastNumRPar = false;
		while(i < max){
			c = f.charAt(i);
			//si es un numero
			if(Character.isDigit(c)){
				//quitar
				String doub = takeNumber(f.substring(i));
				double d = Double.parseDouble(doub);
				b = doubleToBytes(d);
				instructions.add(NUM);
				addDoubleBytes(b);
				if(d % 1 == 0){
					i += (doub.length()-2);
				}
				else i += doub.length();
				lastNumRPar = true;
			} else if (!Character.isLetter(c)){
				switch(c){
					case '(':
						instStack.push(L_PAR);
						lastNumRPar = false;
						break;
					case ')':
						while(!instStack.isEmpty() && instStack.peek() != L_PAR) {
							instructions.add(instStack.pop());
						}
						if(!instStack.isEmpty() && instStack.peek() == L_PAR) instStack.removeFirst();
						if(!instStack.isEmpty() && precedence(instStack.peek()) >= 6){
							instructions.add(instStack.pop());
						}
						lastNumRPar = true;
						break;
					case '+':
						if(instStack.isEmpty() || instStack.peek() == L_PAR){
							instStack.push(SUMA);
						} else {
							while(!instStack.isEmpty()){
								instructions.add(instStack.pop());
							}
							instStack.push(SUMA);
						}
						lastNumRPar = false;
						break;
					case '-':
						if(instructions.isEmpty() || !lastNumRPar){
							instStack.push(NEG);
						} else {
							if(instStack.isEmpty() || instStack.peek() == L_PAR){
								instStack.push(RESTA);
							} else {
								while(!instStack.isEmpty()){
									instructions.add(instStack.pop());
								}
								instStack.push(RESTA);
							}
						}
						lastNumRPar = false;
						break;
					case '*':
						if(instStack.isEmpty() || instStack.peek() == L_PAR){
							instStack.push(MULT);
						} else if(precedence(MULT) > precedence(instStack.peek())){
							instStack.push(MULT);
						} else {
							while (precedence(MULT) <= precedence(instStack.peek())){
								instructions.add(instStack.pop());
							}
							instStack.push(MULT);
						}
						lastNumRPar = false;
						break;
					case '/':
						if(instStack.isEmpty() || instStack.peek() == L_PAR){
							instStack.push(DIV);
						} else if(precedence(DIV) > precedence(instStack.peek())){
							instStack.push(DIV);
						} else {
							while (precedence(DIV) <= precedence(instStack.peek())){
								instructions.add(instStack.pop());
							}
							instStack.push(DIV);
						}
						lastNumRPar = false;
						break;
					case '^':
						if(instStack.isEmpty() || instStack.peek() == L_PAR){
							instStack.push(POT);
						} else if (precedence(POT) >= precedence(instStack.peek())){
								instStack.push(POT);
						} else {
							while(precedence(POT) < precedence(instStack.peek())){
								instructions.add(instStack.pop());
							}
						}
						lastNumRPar = false;
						break;
				}
				++i;
			} else {
				i += takeFun(f.substring(i));
				lastNumRPar = false;
			}
		}
		while(!instStack.isEmpty()){
			instructions.add(instStack.pop());
		}
	}
	
	/**
	 * recibe un doble y devuelve un arreglo de bytes que lo representa
	 * @param d
	 * @return 
	 */
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
	
	/**
	 * recibe un arreglo de bytes y devuelve el double representado
	 * @param b
	 * @return 
	 */
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
	* recibe una cadena y agrega al stack la función correspondiente
	*
	* @param ...
	* @return int lenght
	*/
	private static int takeFun(String s) throws InvalidInput{
		Scanner scanner = new Scanner(s);
		scanner.useDelimiter("[0-9]|(\\(|\\)|\\*|\\+|\\-|\\=|\\[|\\]|\\^|\\/)");
		String s1 = "";
		if (scanner.hasNext()) {
			s1 = scanner.next();
			switch(s1){
				case "sqrt":
					instStack.push(SQRT);
					break;
				case "cosh":
					instStack.push(COSH);
					break;
				case "sinh": case "senh":
					instStack.push(SENH);
					break;
				case "tanh":
					instStack.push(TANH);
					break;
				case "sech":
					instStack.push(SECH);
					break;
				case "csch":
					instStack.push(CSCH);
					break;
				case "coth": case "ctgh":
					instStack.push(COTH);
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
				case "sec":
					instStack.push(SEC);
					break;
				case "csc":
					instStack.push(CSC);
					break;
				case "cot": case "ctg":
					instStack.push(COT);
					break;
				case "ln":
					instStack.push(LN);
					break;
				case "pi": case "PI":
					instructions.push(PI);
				default:
					if(s1.equals(var1)){
						instructions.add(VAR);
					} else if(s1.equals(var2)){
						instructions.add(VAR2);
					} else if(s1.equals(var3)){
						instructions.add(VAR3);
					} else throw new InvalidInput(s1);
			}
		}
		scanner.close();
		return s1.length();
	}
	private static String takeNumber(String s){
		// crea un scanner con la cadena
		Scanner scanner = new Scanner(s);
		scanner.useDelimiter("[a-zA-Z]|(\\(|\\)|\\*|\\+|\\-|\\=|\\[|\\]|\\^|\\/)");

		// use US locale to be able to identify doubles in the string
		//scanner.useLocale(Locale.US);

		double d=0;
			// si el siguiente es doble toma el valor
		if (scanner.hasNextDouble()) {
			d =  scanner.nextDouble();
		}

		scanner.close();
		return String.valueOf(d);
	}
	
	private static int precedence(byte op){
		switch(op){
			case SQRT:	case SEN:	case COS:	case TAN:	case SEC:	case CSC:
			case COT:	case SENH:	case COSH:	case TANH:	case SECH:	case CSCH:
			case COTH:	case LN:
				return 6;
			case POT:
				return 5;
			case NEG:
				return 4;
			case MULT:	case DIV:
				return 3;
			case SUMA:	case RESTA:
				return 2;
			default: return 0;
		}
	}
        public static boolean isBlank(String s){
            return (s == null) || (s.trim().length() == 0);
            }
}
