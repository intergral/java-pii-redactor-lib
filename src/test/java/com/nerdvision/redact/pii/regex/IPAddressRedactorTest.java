package com.nerdvision.redact.pii.regex;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPAddressRedactorTest
{


    private IPAddressRedactor ipAddressRedactor;


    @Before
    public void setUp() throws Exception
    {
        ipAddressRedactor = new IPAddressRedactor();
    }


    @Test
    public void ipaddresses()
    {
        assertEquals( "IP_ADDRESS", ipAddressRedactor.redact( "10.1.1.235" ) );
        assertEquals( "my ip is IP_ADDRESS", ipAddressRedactor.redact( "my ip is 10.1.1.235" ) );
        assertEquals( "what is ::/0", ipAddressRedactor.redact( "what is ::/0" ) );
        assertEquals( "my ip is IP_ADDRESS", ipAddressRedactor.redact( "my ip is 1234:ABCD:23AF:1111:2222:3333:0000:0000:0000" ) );
        assertEquals( "my ip is IP_ADDRESS", ipAddressRedactor.redact( "my ip is 1234:ABCD:23AF:1111:2222:3333::" ) );
        assertEquals( "i have two ips IP_ADDRESS and IP_ADDRESS", ipAddressRedactor.redact( "i have two ips 1234:ABCD:23AF:1111:2222:3333:: and 10.1.1.235" ) );
    }
}
