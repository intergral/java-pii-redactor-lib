package com.nerdvision.redact.pii;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameRedactor implements ISyncRedactor
{
    static Pattern GREETING_REGEX = Pattern.compile( "(^|\\.\\s+)(dear|hi|hello|greetings|hey| hey there)(.*)",
            Pattern.CASE_INSENSITIVE );

    static Pattern CLOSING_REGEX = Pattern.compile(
            "(.*)(thx|thanks| thank you|hope to hear from you soon|regards|best|[a-z]+ly|[a-z]+regards| all the best|happy [a-z]+ing| take care| have a[ a-z]+(weekend|night|day))(.*)",
            Pattern.CASE_INSENSITIVE );

    private final String replaceWith;


    public NameRedactor()
    {
        this( "PERSON_NAME" );
    }


    public NameRedactor( final String replaceWith )
    {
        this.replaceWith = replaceWith;
    }


    public String redact( final String textToRedact )
    {
        return matchAndTokenizeNames( CLOSING_REGEX, matchAndTokenizeNames( GREETING_REGEX, textToRedact ) );
    }


    private String matchAndTokenizeNames( final Pattern pattern, final String textToRedact )
    {
        final StringBuilder stringBuilder = new StringBuilder();
        final Matcher matcher = pattern.matcher( textToRedact );
        if( matcher.matches() )
        {
            final String start = matcher.group( 1 );
            final String group = matcher.group( 2 );
            stringBuilder.append( start ).append( group );
            int tokenPosition = stringBuilder.length();
            final String delim = " \t\n\r\f,.-";
            final StringTokenizer stringTokenizer = new StringTokenizer( textToRedact.substring( tokenPosition ),
                    delim, true );
            while( stringTokenizer.hasMoreTokens() )
            {
                final String nextToken = stringTokenizer.nextToken();
                tokenPosition += nextToken.length();
                // if value is delimeter then append to response
                if( delim.contains( nextToken ) )
                {
                    stringBuilder.append( nextToken );
                }
                // if it is a name append to response
                else if( WellKnownNames.NAMES.contains( nextToken ) )
                {
                    stringBuilder.append( replaceWith );
                }
                // else we are some other word so append then break
                else
                {
                    // check for generic names
                    if( Character.isUpperCase( nextToken.charAt( 0 ) ) )
                    {
                        stringBuilder.append( replaceWith );
                    }
                    else
                    {
                        stringBuilder.append( nextToken );
                        break;
                    }
                }
            }
            stringBuilder.append( textToRedact.substring( tokenPosition ) );
        }
        else
        {
            return textToRedact;
        }

        return stringBuilder.toString();
    }
}
