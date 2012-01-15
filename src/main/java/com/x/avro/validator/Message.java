package com.x.avro.validator;

import org.apache.avro.Schema;

public class Message {
    public static enum Encoding {
        JSON, BINARY
    }

    public Message(Schema schema, String jsonMessage) {
    }

    public Message(Schema schema, byte[] binaryMessage) {
    }

    public Message(Schema messageSchema) {
    }

    public void validate() throws InvalidMessageException {
    }

    public String generateSample(Encoding encoding) {
        return null;
    }
}
