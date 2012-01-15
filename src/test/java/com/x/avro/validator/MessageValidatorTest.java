package com.x.avro.validator;

import org.apache.avro.Schema;
import org.junit.Assert;
import org.junit.Test;

public class MessageValidatorTest {

    private String validJsonPayload = "";
    private byte[] validBinaryPayload = new byte[5];
    private String invalidPayload = "";
    private String differentJsonPayload = "";
    private String sampleJsonPayload = "";
    private Schema testSchema = this.getTestSchema();

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testValidationWithMissingSchema() throws Exception {
        Message testMsg = new Message(null);
        testMsg.validate();
    }

    @Test
    public void testValidationWithJsonMessage() throws Exception {
        Message testMsg = new Message(this.testSchema, this.validJsonPayload);
        testMsg.validate();
    }

    @Test
    public void testValidationWithBinaryMessage() throws Exception {
        Message testMsg = new Message(this.testSchema, this.validBinaryPayload);
        testMsg.validate();
    }

    @Test(expected = com.x.avro.validator.InvalidMessageException.class)
    public void testValidationWithInvalidMessage() throws Exception {
        Message testMsg = new Message(this.testSchema, this.invalidPayload);
        testMsg.validate();
    }

    @Test(expected = com.x.avro.validator.InvalidMessageException.class)
    public void testValidationWithMessageMismatchingSchema() throws Exception {
        Message testMsg = new Message(this.testSchema, this.differentJsonPayload);
        testMsg.validate();
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testValidationWithNullMessage() throws Exception {
        Message testMsg = new Message(this.testSchema);
        testMsg.validate();
    }

    @Test
    public void testGenerationOfSampleMessage() throws Exception {
        Message testMsg = new Message(this.testSchema);
        String jsonPayload = testMsg.generateSample(Message.Encoding.JSON);
        Assert.assertEquals(this.sampleJsonPayload, jsonPayload);
    }

    private Schema getTestSchema() {
        return null;
    }
}
