package com.nerdvision.redact.pii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WellKnownNames
{
    private WellKnownNames()
    {
    }


    static Set<String> NAMES;

    static
    {
        final InputStream resourceAsStream = WellKnownNames.class.getResourceAsStream( "/well-known-names.csv" );
        final BufferedReader r = new BufferedReader( new InputStreamReader( resourceAsStream ) );

        final HashSet<String> strings = new HashSet<String>();
        String line;
        while( true )
        {
            try
            {
                if( (line = r.readLine()) == null )
                {
                    break;
                }
                strings.add( line.toLowerCase() );
            }
            catch( IOException e )
            {
                e.printStackTrace();
            }
        }
        try
        {
            r.close();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
        NAMES = Collections.unmodifiableSet( strings );
    }
}
