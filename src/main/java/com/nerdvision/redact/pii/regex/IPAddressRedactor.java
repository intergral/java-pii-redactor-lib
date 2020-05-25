package com.nerdvision.redact.pii.regex;

public class IPAddressRedactor extends RegexRedactor
{
    public IPAddressRedactor()
    {
        super( "(\\d{1,3}(\\.\\d{1,3}){3}|[0-9A-F]{4}(:[0-9A-F]{4}){5}(::|(:0000)+))", "IP_ADDRESS" );
    }
}
