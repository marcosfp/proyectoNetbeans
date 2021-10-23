/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed.proyectonetbeans.segundo;


//import com.sun.media.sound.WaveFileReader;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;

import javax.sound.sampled.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.io.*;

/**
 *
 * @author marco
 */
public class Cancion implements Archvo {


    private String rutaCancion = "src/main/resources/cancion.au";

    @Override
    public void abrirArchivo() {

        try{

            File musicPath = new File(rutaCancion);

            if(musicPath.exists()){

                AudioInputStream audioInpit= AudioSystem.getAudioInputStream(musicPath);
                Clip clip= AudioSystem.getClip();
                clip.open(audioInpit);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

                JOptionPane.showMessageDialog(null,"Enciende los altavoces");
                long cliptimePosition = clip.getMicrosecondPosition();

                JOptionPane.showMessageDialog(null,"Pulsa ok para reactivar");
                clip.setMicrosecondPosition(cliptimePosition);
                clip.start();

                JOptionPane.showMessageDialog(null,"Pulsa ok para para el archivo");

            }else{
                System.out.println("El archivo no existe");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}