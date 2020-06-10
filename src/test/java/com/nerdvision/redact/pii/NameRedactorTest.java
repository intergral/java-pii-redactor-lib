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
import static org.junit.Assert.assertEquals;

public class NameRedactorTest
{


    private NameRedactor nameRedactor;


    @Before
    public void setUp() throws Exception
    {
        nameRedactor = new NameRedactor();
    }


    @Test
    public void greeting_redaction()
    {
        assertEquals( "dear PERSON_NAME, i want something. ", nameRedactor.redact( "dear ben, i want something. " ) );
        assertEquals( "dear PERSON_NAME donath, i want something. ",
                nameRedactor.redact( "dear ben donath, i want something. " ) );
        assertEquals( "dear PERSON_NAME PERSON_NAME, i want something. ",
                nameRedactor.redact( "dear ben Donath, i want something. " ) );
    }


    @Test
    public void closing_redaction()
    {
        assertEquals( "i want something. thanks PERSON_NAME ", nameRedactor.redact( "i want something. thanks ben " ) );
        assertEquals( "i want something. thanks PERSON_NAME donath",
                nameRedactor.redact( "i want something. thanks ben donath" ) );
        assertEquals( "i want something. thanks PERSON_NAME PERSON_NAME",
                nameRedactor.redact( "i want something. thanks ben Donath" ) );
    }


    @Test
    public void greeting_closing_redaction()
    {
        assertEquals( "dear PERSON_NAME, i want something. thanks PERSON_NAME ",
                nameRedactor.redact( "dear ben, i want something. thanks ben " ) );
        assertEquals( "dear PERSON_NAME donath, i want something. thanks PERSON_NAME donath",
                nameRedactor.redact( "dear ben donath, i want something. thanks ben donath" ) );
        assertEquals( "dear PERSON_NAME PERSON_NAME, i want something. thanks PERSON_NAME donath",
                nameRedactor.redact( "dear ben Donath, i want something. thanks ben donath" ) );
        assertEquals( "dear PERSON_NAME donath, i want something. thanks PERSON_NAME PERSON_NAME",
                nameRedactor.redact( "dear ben donath, i want something. thanks ben Donath" ) );
        assertEquals( "dear PERSON_NAME PERSON_NAME, i want something. thanks PERSON_NAME PERSON_NAME",
                nameRedactor.redact( "dear ben Donath, i want something. thanks ben Donath" ) );
    }
}
