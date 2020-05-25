package com.nerdvision.redact.pii.regex;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SocialSecurityRedactorTest
{


    private SocialSecurityRedactor socialSecurityRedactor;


    @Before
    public void setUp() throws Exception
    {
        socialSecurityRedactor = new SocialSecurityRedactor();
    }


    @Test
    public void socialSecurityRedactor()
    {
//        assertEquals( "US_SOCIAL_SECURITY_NUMBER", socialSecurityRedactor.redact( "123456789" ) );
        assertEquals( "US_SOCIAL_SECURITY_NUMBER", socialSecurityRedactor.redact( "123 45 6789" ) );
        assertEquals( "US_SOCIAL_SECURITY_NUMBER", socialSecurityRedactor.redact( "123-45-6789" ) );
        assertEquals( "US_SOCIAL_SECURITY_NUMBER", socialSecurityRedactor.redact( "123.45.6789" ) );
    }
}
