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
