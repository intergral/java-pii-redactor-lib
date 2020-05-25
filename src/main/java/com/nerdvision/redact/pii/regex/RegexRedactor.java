package com.nerdvision.redact.pii.regex;

import com.nerdvision.redact.pii.ISyncRedactor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexRedactor implements ISyncRedactor
{
    private final Pattern pattern;
    private final String replacement;


    public RegexRedactor( final String pattern, final String replacement )
    {
        this.pattern = Pattern.compile( pattern );
        this.replacement = replacement;
    }


    public String redact( String textToRedact )
    {
        return this.pattern.matcher( textToRedact ).replaceAll(replacement);
    }
}
