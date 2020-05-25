package com.nerdvision.redact.pii.regex;

public class ZIPCodeRedactor extends RegexRedactor
{
    public ZIPCodeRedactor()
    {
        super( "(^\\d{5}$)|(^\\d{9}$)|(^\\d{5}-\\d{4}$)", "ZIP_CODE" );
    }
}
