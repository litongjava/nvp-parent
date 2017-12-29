package com.vxml.utils;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by litong on 2017/12/28.
 */
public class GetAudioInfo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        String filename="D:\\IdeaProjects\\nvp-parent\\nvp-gzdw\\src\\main\\resources\\static\\wav\\A11.wav";
        list.add(filename);
        String filename2="D:\\IdeaProjects\\nvp-parent\\nvp-gzdw\\src\\main\\resources\\static\\wav\\A1_1p.wav";
        list.add(filename2);
        File file = new File(filename2);
        AudioInputStream ais=null;
        try {
            ais = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AudioFormat format = ais.getFormat();
        System.out.println(format);
        try {
            ais.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
