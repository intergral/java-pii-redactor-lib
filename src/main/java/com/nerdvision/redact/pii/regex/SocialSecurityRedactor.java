package com.nerdvision.redact.pii.regex;

public class SocialSecurityRedactor extends RegexRedactor
{
    public SocialSecurityRedactor()
    {
        super( "\\b\\d{3}[ -.]\\d{2}[ -.]\\d{4}\\b", "US_SOCIAL_SECURITY_NUMBER" );
    }
}
