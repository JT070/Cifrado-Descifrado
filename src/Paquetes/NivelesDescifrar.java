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
public class NivelesDescifrar {
    
    public String NivelUno(String mensaje){
        char AlfabetoMinus[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char AlfabetoMayus[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char Numeros[] = {'0','1','2','3','4','5','6','7','8','9'};
        char JCLetrasMinus[] = {'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i'}; 
        char JCLetrasMayus[] = {'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I'};
        char JCNumeros[] = {'7','8','9','0','1','2','3','4','5','6'}; 
        char[] mensajeArray = mensaje.toCharArray();  
        char ArrayMensaje[];
        ArrayMensaje = new char[mensajeArray.length];
        int posicion=0;
        for(posicion=0; posicion < mensajeArray.length; posicion++){
            if(Character.isUpperCase(mensajeArray[posicion])){
                for(int j=0; j<=26; j++){
                    if(JCLetrasMayus[j] == mensajeArray[posicion]){
                        ArrayMensaje[posicion] = AlfabetoMayus[j];
                        break;
                    }
                }
            }
            else if(Character.isLowerCase(mensajeArray[posicion])){
                for(int k=0; k<=26; k++){
                    if(JCLetrasMinus[k] == mensajeArray[posicion]){
                        ArrayMensaje[posicion] = AlfabetoMinus[k];
                        break;
                    }
                }              
            }
            else if(Character.isDigit(mensajeArray[posicion])){
                for(int l=0; l<=10; l++){
                    if(JCNumeros[l] == mensajeArray[posicion]){
                        ArrayMensaje[posicion] = Numeros[l];
                        break;
                    }
                }
            }
            else if(Character.isSpaceChar(mensajeArray[posicion])){
                ArrayMensaje[posicion] = ' ';
            }
            else{
                ArrayMensaje[posicion] = mensajeArray[posicion];
            }
        }        
        String mensajeCifrado = new String(ArrayMensaje);        
        return mensajeCifrado;
    }
    
    
    public String NivelDos(String mensaje){
        
        int BDNum[][] = { {0,0,0,0,0,0,0,0,0,9,9,9,9,9,9,9,9,9,
                           1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,
                           3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,
                           5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,
                           7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8  }  ,
            
                           {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,
                            1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,
                            1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,
                            1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,
                            1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9}  };        
        
        char BD[] = {'j','k','T','U','l','m','V','W','n','o','X','Y','p','q','Z','A','r','s',
                     'B','C','t','u','D','E','v','w','F','G','x','y','H','I','z','a','J','K',
                     'b','c','L','M','d','e','N','O','f','g','P','Q','h','i','R','S',' ','.',
                     '0','1','2','3','4','5','6','7','8','9','á','é','í','ó','ú','<','>','|',
                     '!','@','#','$','%','&','/','(',')',',','=','?','¿','_',':',';','*','-'};
        
        char[] mensajeArray = mensaje.toCharArray();
        char letra = 0;
        String digito="", mensajeDescifrado="";
        int contador=0, referenciaInt=0, ref1=0, ref2=0; 
        double Resul1=0, Resul2=0;
        
        Transformar trans = new Transformar();
        
        for(int i=0; i<mensaje.length(); i++){  // Paso letra por letra del mensaje a una variable char   
            if(mensajeArray[i] != 'A' || mensajeArray[i] != 'B' ){ 
                digito = digito + mensajeArray[i];
            }
            if(mensajeArray[i] == 'A' && contador == 0){
                Resul1 = trans.hexadecimalDecimal(digito);
                digito="";
                ref1 = (int)(Math.log(Resul1) / Math.log(5) ) ; 
                contador += 1;
            }else if(mensajeArray[i] == 'B' && contador == 1 ){
                Resul2 = trans.hexadecimalDecimal(digito);
                digito="";
                ref2 = (int)(Math.log(Resul2) / Math.log(5) ) ; 
                contador += 1;
            }
            if(contador == 2){
                for(int k=0; k<90; k++){
                    if(BDNum[0][k] == ref1 && BDNum[1][k] == ref2){
                        referenciaInt = k;
                        letra = BD[referenciaInt];
                    }
                }
                mensajeDescifrado = mensajeDescifrado + letra;
                contador=0;
            }
        }
        return mensajeDescifrado;
    }
    
}
