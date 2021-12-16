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
public class NivelesCifrar {
    
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
                    if(AlfabetoMayus[j] == mensajeArray[posicion]){
                        ArrayMensaje[posicion] = JCLetrasMayus[j];
                        break;
                    }
                }
            }
            else if(Character.isLowerCase(mensajeArray[posicion])){
                for(int k=0; k<=26; k++){
                    if(AlfabetoMinus[k] == mensajeArray[posicion]){
                        ArrayMensaje[posicion] = JCLetrasMinus[k];
                        break;
                    }
                }              
            }
            else if(Character.isDigit(mensajeArray[posicion])){
                for(int l=0; l<=10; l++){
                    if(Numeros[l] == mensajeArray[posicion]){
                        ArrayMensaje[posicion] = JCNumeros[l];
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
        
        double BDNum[][] = { {0,0,0,0,0,0,0,0,0,9,9,9,9,9,9,9,9,9,
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
        String mensajeEncriptado = "", ME="";
        double Ref1, Ref2;
        String RefHex1, RefHex2;
        
        for(int j=0; j <= (mensajeArray.length)-1; j++){
            for(int i=0; i<90; i++){
                if( BD[i] == mensajeArray[j] ){                    
                    Transformar trans = new Transformar();
                    Ref1 = BDNum[0][i];
                    Ref2 = BDNum[1][i];
                    Ref1 = Math.pow(5,Ref1);
                    Ref2 = Math.pow(5,Ref2);
                    RefHex1 = trans.decimalHexadecimal(Ref1);
                    RefHex2 = trans.decimalHexadecimal(Ref2);
                    ME = RefHex1 + 'A' + RefHex2 + 'B';                    
                    mensajeEncriptado = mensajeEncriptado+ME;
                }
            }
        }
        return mensajeEncriptado;
    }
}
