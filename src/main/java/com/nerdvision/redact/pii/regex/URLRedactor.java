package com.nerdvision.redact.pii.regex;

public class URLRedactor extends RegexRedactor
{
    public URLRedactor()
    {
        super( "([^\\s:/?#]+):\\/\\/([^/?#\\s]*)([^?#\\s]*)(\\?([^#\\s]*))?(#([^\\s]*))?", "URL" );
    }
}
