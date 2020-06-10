/*
 Copyright [2020] [Intergral GmbH]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/

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
