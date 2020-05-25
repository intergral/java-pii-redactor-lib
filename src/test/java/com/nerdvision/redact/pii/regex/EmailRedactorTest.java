package com.nerdvision.redact.pii.regex;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmailRedactorTest
{


    private EmailRedactor emailRedactor;


    @Before
    public void setUp() throws Exception
    {
        emailRedactor = new EmailRedactor();
    }


    @Test
    public void emailRedactor()
    {
        assertEquals( "my email is EMAIL_ADDRESS.", emailRedactor.redact( "my email is ben@nerd.vision." ) );
        assertEquals( "my email is EMAIL_ADDRESS.", emailRedactor.redact( "my email is ben@googlemail.com." ) );
        assertEquals( "my email is EMAIL_ADDRESS.", emailRedactor.redact( "my email is ben@nerdviion.io." ) );
        assertEquals( "my email is EMAIL_ADDRESS.", emailRedactor.redact( "my email is ben_donnelly+somefilter@nerdviion.io." ) );
        assertEquals( "my email is EMAIL_ADDRESS.", emailRedactor.redact( "my email is b.e.n_d_o_n_n_e_l_l.y+somefilter@nerdviion.io." ) );
    }
}
