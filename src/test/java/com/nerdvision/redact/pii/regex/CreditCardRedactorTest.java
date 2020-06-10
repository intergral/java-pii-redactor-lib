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
