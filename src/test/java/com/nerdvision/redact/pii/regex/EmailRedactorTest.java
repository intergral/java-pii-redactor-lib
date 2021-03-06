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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmailRedactorTest
{


    private EmailRedactor emailRedactor;


    @Before
    public void setUp() throws Exception
    {
        emailRedactor = new EmailRedactor();
    }


    @Test
    public void emailRedactor()
    {
        assertEquals( "my email is EMAIL_ADDRESS.", emailRedactor.redact( "my email is asdasd@nerd.vision." ) );
        assertEquals( "my email is EMAIL_ADDRESS.", emailRedactor.redact( "my email is asdasdsad@googlemail.com." ) );
        assertEquals( "my email is EMAIL_ADDRESS.", emailRedactor.redact( "my email is asdasdsad@nerdviion.io." ) );
        assertEquals( "my email is EMAIL_ADDRESS.", emailRedactor.redact( "my email is asdasdsad_donnelly+somefilter@nerdviion.io." ) );
        assertEquals( "my email is EMAIL_ADDRESS.", emailRedactor.redact( "my email is a.s.d_d_d_f_e_r_g_e.y+somefilter@nerdviion.io." ) );
    }
}
