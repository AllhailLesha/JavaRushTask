package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) throws IllegalArgumentException {
        if(imageTypes != null) {
            switch (imageTypes) {
                case JPG:
                    return new JpgReader();
                case BMP:
                    return new BmpReader();
                case PNG:
                    return new PngReader();
            }
        }
        throw new IllegalArgumentException();
    }
}
