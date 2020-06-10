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
        piiRedactor = PiiRedactor.getInstance();
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
                + "my website is on http://example.com. You can email me via befsdn@nerd.vision."
                + " If you need to call be please use my mobile on: 01707855407."
                + "hope to hear from you soon."
                + "Ben" ) );
    }
}
