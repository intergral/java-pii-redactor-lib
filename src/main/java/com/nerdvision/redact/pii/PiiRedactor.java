package com.nerdvision.redact.pii;

import com.nerdvision.redact.pii.regex.CreditCardRedactor;
import com.nerdvision.redact.pii.regex.EmailRedactor;
import com.nerdvision.redact.pii.regex.IPAddressRedactor;
import com.nerdvision.redact.pii.regex.PhoneNumberRedactor;
import com.nerdvision.redact.pii.regex.SocialSecurityRedactor;
import com.nerdvision.redact.pii.regex.URLRedactor;
import com.nerdvision.redact.pii.regex.ZIPCodeRedactor;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class PiiRedactor implements ISyncRedactor
{
    private static final PiiRedactor INSTANCE = new PiiRedactor();

    private Set<ISyncRedactor> REDACTORS = new LinkedHashSet<ISyncRedactor>()
    {{
        add( new NameRedactor() );
        add( new CreditCardRedactor() );
        add( new IPAddressRedactor() );
        add( new PhoneNumberRedactor() );
        add( new SocialSecurityRedactor() );
        add( new URLRedactor() );
        add( new ZIPCodeRedactor() );
        add( new EmailRedactor() );
    }};


    public static PiiRedactor getInstance()
    {
        return INSTANCE;
    }


    public String redact( String textToRedact )
    {
        for( ISyncRedactor redactor : REDACTORS )
        {
            textToRedact = redactor.redact( textToRedact );
        }
        return textToRedact;
    }
}
