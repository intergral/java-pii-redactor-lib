package com.nerdvision.redact.pii;

import org.junit.Test;
import static org.junit.Assert.*;

public class WellKnownNamesTest
{
    @Test
    public void name()
    {
        assertTrue( WellKnownNames.NAMES.contains( "ben" ) );
        assertTrue( WellKnownNames.NAMES.contains( "bernd" ) );
    }
}
