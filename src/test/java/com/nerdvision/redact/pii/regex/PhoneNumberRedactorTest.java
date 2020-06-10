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

public class PhoneNumberRedactorTest
{


    private PhoneNumberRedactor phoneNumberRedactor;


    @Before
    public void setUp() throws Exception
    {
        phoneNumberRedactor = new PhoneNumberRedactor();
    }


    @Test
    public void phoneNumberRedactor()
    {
        assertEquals( "my phone: PHONE_NUMBER.", phoneNumberRedactor.redact( "my phone: 5551231234." ) );
        assertEquals( "my phone: PHONE_NUMBER.", phoneNumberRedactor.redact( "my phone: (+44) (555)123-1234." ) );
        assertEquals( "my phone: PHONE_NUMBER.", phoneNumberRedactor.redact( "my phone: 1-555-123-1234." ) );
        assertEquals( "my phone: PHONE_NUMBER.", phoneNumberRedactor.redact( "my phone: 555.123.1234." ) );

        assertEquals( "my phone: PHONE_NUMBER", phoneNumberRedactor.redact( "my phone: 00441707774707" ) );
        assertEquals( "my phone: PHONE_NUMBER", phoneNumberRedactor.redact( "my phone: 0044 1707 774 707" ) ); //?
        assertEquals( "my phone: PHONE_NUMBER", phoneNumberRedactor.redact( "my phone: +44 1707 774 707" ) );
        assertEquals( "my phone: PHONE_NUMBER", phoneNumberRedactor.redact( "my phone: +44 (0) 1707 774 707" ) );
        assertEquals( "my phone: PHONE_NUMBER", phoneNumberRedactor.redact( "my phone: 01707 774 707" ) );
        assertEquals( "my phone: PHONE_NUMBER", phoneNumberRedactor.redact( "my phone: 774 707" ) );
    }
}
