package com.nerdvision.redact.pii.regex;

import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreditCardRedactorTest
{
    private CreditCardRedactor creditCardRedactor;


    @Before
    public void setUp() throws Exception
    {
        creditCardRedactor = new CreditCardRedactor();
    }


    @Test
    public void creditCardRegex()
    {
        assertEquals("CREDIT_CARD", creditCardRedactor.redact( "1234 5678 8765 4321"));
        assertEquals("CREDIT_CARD", creditCardRedactor.redact( "1234-5678-8765-4321"));
        assertEquals("CREDIT_CARD", creditCardRedactor.redact( "1234 5678 8765 4321"));
        assertEquals("CREDIT_CARD", creditCardRedactor.redact( "1234 567890 12345"));
        assertEquals("CREDIT_CARD", creditCardRedactor.redact( "1234-567890-12345"));
        assertEquals("CREDIT_CARD", creditCardRedactor.redact( "1234 567890 1234"));
        assertEquals("CREDIT_CARD", creditCardRedactor.redact( "1234-567890-1234"));
        assertEquals("CREDIT_CARD", creditCardRedactor.redact( "12345678901234"));

        assertEquals("CREDIT_CARD", creditCardRedactor.redact( "123456789012345"));

        assertEquals("my card number is: CREDIT_CARD", creditCardRedactor.redact( "my card number is: 12345678901234"));
        assertEquals("my card number is: CREDIT_CARD or use this one CREDIT_CARD", creditCardRedactor.redact( "my card number is: 12345678901234 or use this one 1234 567890 12345"));
    }
}
