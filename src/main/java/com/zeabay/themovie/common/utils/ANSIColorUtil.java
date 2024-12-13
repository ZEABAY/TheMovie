package com.zeabay.themovie.common.utils;

import com.zeabay.themovie.common.enums.ANSIColor;

public class ANSIColorUtil {

    /**
     * Metni belirtilen renkte renklendirir.
     *
     * @param text  Renklendirilecek metin.
     * @param color ANSIColor enum'u ile renk.
     * @return Renklendirilmiş metin.
     */
    public static String colorize(String text, ANSIColor color) {
        return color.getCode() + text + ANSIColor.RESET.getCode();
    }

    /**
     * INFO log başlıkları için renklendirilmiş metin döndürür.
     *
     * @param text Renklendirilecek metin.
     * @return Renklendirilmiş INFO metni.
     */
    public static String info(String text) {
        return colorize(text, ANSIColor.YELLOW);
    }

    /**
     * ERROR log başlıkları için renklendirilmiş metin döndürür.
     *
     * @param text Renklendirilecek metin.
     * @return Renklendirilmiş ERROR metni.
     */
    public static String error(String text) {
        return colorize(text, ANSIColor.RED);
    }

    /**
     * SUCCESS log başlıkları için renklendirilmiş metin döndürür.
     *
     * @param text Renklendirilecek metin.
     * @return Renklendirilmiş SUCCESS metni.
     */
    public static String success(String text) {
        return colorize(text, ANSIColor.GREEN);
    }
}