/**
 * Copyright 2011-2014 the original author or authors.
 */
package com.jetdrone.vertx.yoke.middleware.filters;

import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/**
 * # DeflateWriterFilter
 */
public class DeflateWriterFilter extends AbstractWriterFilter {

    public DeflateWriterFilter(Pattern filter) throws IOException {
        super(filter);
    }

    @Override
    public OutputStream createOutputStream() throws IOException {
        return new GZIPOutputStream(new OutputStream() {
            @Override
            public void write(int i) throws IOException {
                buffer.appendByte((byte) i);
            }
        });
    }

    @Override
    public String encoding() {
        return "deflate";
    }
}
