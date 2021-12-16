/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquetes;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */

public class Fondos extends JPanel{
    
    private Image imagen;
    
    @Override
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("/Imagenes/One-Piece-Pirate-Warriors-4-Wano-Country-Screenshots-0.jpg")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);  //Si lo quitamos, dibuja el fondo por defecto del panel.
        super.paint(g);     //Si lo quitamos, no nos salen todos los componentes de la ventana.
    }
    
    
}
