package com.nerdvision.redact.pii.regex;

public class EmailRedactor extends RegexRedactor
{
    public EmailRedactor()
    {
        super( "([a-z0-9_\\-.+]+)@\\w+(\\.\\w+)*", "EMAIL_ADDRESS" );
    }
}
