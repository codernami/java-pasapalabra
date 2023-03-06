/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication30;

import java.awt.Image;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 *
 * @author balbi
 */
public class Metodos {
    public int segundos=180;
    
    public void btncolor(JButton nombre,String color){
        ImageIcon redondo = new ImageIcon(getClass().getResource(color+".png"));
        int alto = nombre.getHeight();
        int ancho = nombre.getWidth();
        ImageIcon boton = new
                ImageIcon(redondo.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        
        nombre.setIcon(boton);
    }
    
 public void cartel(JLabel pregunta){
       Thread letras;
       letras = new Thread(){
                public void run(){    
    for(int i = 0; i < 32; i++) {   
      pregunta.setFont(
         new java.awt.Font("Tahoma",1,i));
      try {
          Thread.sleep(50);
      } catch (InterruptedException ex) {
          System.out.println("Error en el Hilo");
      }
       }}};
        letras.start();
   }
 public void tiempo(JButton cuenta){
       Thread tiempo;
       tiempo = new Thread(){
                public void run(){    
    for(int i = 180; i >= 0; i--) {   
      cuenta.setText(String.valueOf(i));
      try {
          if(i==13){
              faltan10();
          }
          Thread.sleep(1000);
          if(i>segundos){
              i=segundos;
          }
      } catch (InterruptedException ex) {
          System.out.println("Error en el Hilo");
      }
       }}};
        tiempo.start();
   }

    

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
    public void aplausos(){
               Thread aplausos;
       aplausos = new Thread(){
                public void run(){ 
        try {
         Clip sonido = AudioSystem.getClip();
         File a = new File("aplauso.wav");
         sonido.open(AudioSystem.getAudioInputStream(a));
         sonido.start();
//         System.out.println("Reproduciendo 10s. de sonido...");
         Thread.sleep(3000); // 1000 milisegundos (10 segundos)
         sonido.close();
      } catch (Exception tipoError) {
         System.out.println("" + tipoError);
      }
        
        }};
        aplausos.start();
    }

     public void waverror(){
                 Thread aplausos;
       aplausos = new Thread(){
                public void run(){ 
        try {
         Clip sonido = AudioSystem.getClip();
         File a = new File("error.wav");
         sonido.open(AudioSystem.getAudioInputStream(a));
         sonido.start();
//         System.out.println("Reproduciendo 10s. de sonido...");
         Thread.sleep(2000); // 1000 milisegundos (10 segundos)
         sonido.close();
      } catch (Exception tipoError) {
         System.out.println("" + tipoError);
      }
        
        }};
        aplausos.start();
    }
      public void faltan10(){
                 Thread faltan10;
       faltan10 = new Thread(){
                public void run(){ 
        try {
         Clip sonido = AudioSystem.getClip();
         File a = new File("segundos.wav");
         sonido.open(AudioSystem.getAudioInputStream(a));
         sonido.start();
//         System.out.println("Reproduciendo 10s. de sonido...");
         Thread.sleep(16000); // 1000 milisegundos (10 segundos)
         sonido.close();
      } catch (Exception tipoError) {
         System.out.println("" + tipoError);
      }
        
        }};
        faltan10.start();
    }
}
