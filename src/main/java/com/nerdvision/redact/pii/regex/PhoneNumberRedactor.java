package com.nerdvision.redact.pii.regex;

public class PhoneNumberRedactor extends RegexRedactor
{
    public PhoneNumberRedactor()
    {
        super( "(\\(?\\+[0-9]{1,2}\\)?[\\s\\.]?|1\\-)?(\\([0-9]{1,3}\\)?[\\s\\.]?|)(([0-9]{4,}[\\s-\\.]?){1,2})?([0-9]{3}[\\s-\\.]?){1,2}([0-9]{3,4})",
                "PHONE_NUMBER" );
    }
}
