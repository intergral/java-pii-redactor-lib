package com.nerdvision.redact.pii.regex;

public class CreditCardRedactor extends RegexRedactor
{
    public CreditCardRedactor()
    {
        super( "\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}|\\d{4}[ -]?\\d{6}[ -]?\\d{4}\\d?", "CREDIT_CARD" );
    }
}
