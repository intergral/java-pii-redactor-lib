package com.nerdvision.redact.pii.regex;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ZIPCodeRedactorTest
{


    private ZIPCodeRedactor zipCodeRedactor;


    @Before
    public void setUp() throws Exception
    {
        zipCodeRedactor = new ZIPCodeRedactor();
    }


    @Test
    public void zipcodeRedactor()
    {
        assertEquals( "my zipcode is: ZIP_CODE", zipCodeRedactor.redact( "my zipcode is: 10002" ) );
        assertEquals( "my zipcode is: ZIP_CODE", zipCodeRedactor.redact( "my zipcode is: 90210" ) );
    }
}
