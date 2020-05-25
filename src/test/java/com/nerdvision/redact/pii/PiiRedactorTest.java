package com.nerdvision.redact.pii;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PiiRedactorTest
{


    private PiiRedactor piiRedactor;


    @Before
    public void setUp() throws Exception
    {
        piiRedactor = new PiiRedactor();
    }


    @Test
    public void redactor()
    {
        assertEquals( "dear PERSON_NAME, "
                + "i am writing to give you my details."
                + "my website is on URL You can email me via EMAIL_ADDRESS."
                + " If you need to call be please use my mobile on: PHONE_NUMBER."
                + "hope to hear from you soon."
                + "PERSON_NAME", piiRedactor.redact( "dear ben, "
                + "i am writing to give you my details."
                + "my website is on http://donnelly.space. You can email me via ben@nerd.vision."
                + " If you need to call be please use my mobile on: 01707855407."
                + "hope to hear from you soon."
                + "Ben" ) );
    }
}
