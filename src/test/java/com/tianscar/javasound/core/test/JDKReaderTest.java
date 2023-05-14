package com.tianscar.javasound.core.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.*;
import java.io.IOException;

public class JDKReaderTest {

    @Test
    @DisplayName("wav -> pcm, play with SPI")
    public void readAndPlayWAV() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(Thread.currentThread().getContextClassLoader().getResourceAsStream("fbodemo1.wav"));
        System.out.println("file format: " + fileFormat);
        System.out.println("file audio format: " + fileFormat.getFormat());
        AudioInputStream stream = AudioSystem.getAudioInputStream(Thread.currentThread().getContextClassLoader().getResourceAsStream("fbodemo1.wav"));
        System.out.println("stream: " + stream);
        System.out.println("stream audio format: " + stream.getFormat());
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, stream.getFormat());
        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
        line.open();
        line.start();
        byte[] buf = new byte[8192];
        while (true) {
            int r = stream.read(buf, 0, buf.length);
            if (r < 0) break;
            line.write(buf, 0, r);
        }
        line.drain();
        line.stop();
        line.close();
        stream.close();
    }

}
