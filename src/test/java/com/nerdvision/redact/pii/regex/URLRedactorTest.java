package com.nerdvision.redact.pii.regex;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class URLRedactorTest
{


    private URLRedactor urlRedactor;


    @Before
    public void setUp() throws Exception
    {
        urlRedactor = new URLRedactor();
    }


    @Test
    public void urlRedactor()
    {
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: https://nerd.vision" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: https://www.nerd.vision" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: https://app.nerd.vision" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: https://nerdvision.com" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: https://nerdvision.io" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: http://nerd.vision" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: http://www.nerd.vision" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: http://app.nerd.vision" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: http://nerdvision.com" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: http://nerdvision.io" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: ftp://nerd.vision" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: smb://www.nerd.vision" ) );
        assertEquals( "my homepage is: URL", urlRedactor.redact( "my homepage is: file://app.nerd.vision" ) );

    }
}
