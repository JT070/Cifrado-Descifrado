/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquetes;

/**
 *
 * @author PC
 */
public class Transformar {
    
    
    public String decimalHexadecimal(double numero){
        
        int decimal = (int)numero;
        int residuo=0;
        String numHex = null; 
        
        while(decimal != 0){
            residuo = decimal%16;
            decimal = decimal/16;            
            if(residuo == 10){
                numHex = numHex + 'A';
            }else if(residuo == 11){
                numHex = numHex + 'B';
            }else if(residuo == 12){
                numHex = numHex + 'C';
            }else if(residuo == 13){
                numHex = numHex + 'D';
            }else if(residuo == 14){
                numHex = numHex + 'E';
            }else if(residuo == 15){
                numHex = numHex + 'F';
            }else{
                numHex = numHex + residuo;
            }            
        }
        //Convierte la cadena en arreglo char y sacamos su tamaño
        char[] numHexArr = numHex.toCharArray();        
        char arreglo[];
        arreglo = new char[numHex.length() - 4];
        int tamanio = numHex.length();
        //Esto es para eliminar las primeras cuatro posiciones y que el arreglo no diga 'null'
        for(int j=0; j<= (numHex.length()) - 4; j++){
            arreglo[j] = numHexArr[tamanio-1];
            tamanio = tamanio-1;
            if(tamanio == 4)
                break;
        }
        String hexadecimal = new String(arreglo);        
        return hexadecimal;
    }
    
    
    public double hexadecimalDecimal(String hexadecimal){
        
        char[] mensajeArray = hexadecimal.toCharArray();
        int tamanio = (mensajeArray.length)-1;
        char volteado[] = new char[(mensajeArray.length)-1];
        
        for(int q=0; q<(mensajeArray.length)-1; q++){  // Invierte el arreglo 
            volteado[q] = mensajeArray[tamanio-1];
            tamanio = tamanio-1;
        }
        
        String digito = "";
        double numero=0, resultadoPot=0, resultado=0;
        
        for(int i=0; i<volteado.length; i++){
            digito = digito + volteado[i];
            if(null != digito)switch (digito) {  //  Transforma las letras en números 
                case "A":
                    numero = 10;
                    digito = "";
                    break;
                case "B":
                    numero = 11;
                    digito = "";
                    break;
                case "C":
                    numero = 12;
                    digito = "";
                    break;
                case "D":
                    numero = 13;
                    digito = "";
                    break;
                case "E":
                    numero = 14;
                    digito = "";
                    break;
                case "F":
                    numero = 15;
                    digito = "";
                    break;
                default:
                    numero = Double.parseDouble(digito);
                    digito="";
                    break;
            }            
            resultadoPot = Math.pow(16, i);
            resultado = (resultadoPot*numero) + resultado;
            resultadoPot=0;            
        }        
        return resultado;
    }
    
    
}
