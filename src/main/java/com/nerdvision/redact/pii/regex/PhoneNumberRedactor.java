/*
 Copyright [2020] [Intergral GmbH]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/

package com.nerdvision.redact.pii.regex;

public class PhoneNumberRedactor extends RegexRedactor
{
    public PhoneNumberRedactor()
    {
        super( "(\\(?\\+[0-9]{1,2}\\)?[\\s\\.]?|1\\-)?(\\([0-9]{1,3}\\)?[\\s\\.]?|)(([0-9]{4,}[\\s-\\.]?){1,2})?([0-9]{3}[\\s-\\.]?){1,2}([0-9]{3,4})",
                "PHONE_NUMBER" );
    }
}
