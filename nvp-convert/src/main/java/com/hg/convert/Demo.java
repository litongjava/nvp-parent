package com.hg.convert;

import java.io.File;

/**
 * Created by litong on 2017/12/27.
 * 转换使用的ffmpeg,win 10系统需要安装对应的版本
 */
public class Demo {
    public static void main(String[] args) {
        File source = new File("D:\\IdeaProjects\\nvp-parent\\nvp-convert\\src\\main\\resources\\file\\source-avi.avi");
        File target = new File("target.flv");
        AudioAttributes audio = new AudioAttributes();

        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(64000));
        audio.setChannels(new Integer(1));
        audio.setSamplingRate(new Integer(22050));

        VideoAttributes video = new VideoAttributes();

        video.setCodec("flv");
        video.setBitRate(new Integer(160000));
        video.setFrameRate(new Integer(15));
        video.setSize(new VideoSize(400, 300));

        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("flv");
        attrs.setAudioAttributes(audio);
        attrs.setVideoAttributes(video);

        Encoder encoder = new Encoder();
        try {
            encoder.encode(source, target, attrs);
        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }
}
