package com.fernando.wksmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

    public static String decodeParam(String text) {

        // texto que irá ser decodificado - padrão de decodificação
        try {
            return URLDecoder.decode(text, "UTF-80");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
