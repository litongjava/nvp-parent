package com.vxml.utils;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringBufferInputStream;
/**
 * Created by litong on 2017/12/4.
 */
public class MyEntryResovler implements EntityResolver{
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        return new InputSource(new StringBufferInputStream(""));
    }
}
