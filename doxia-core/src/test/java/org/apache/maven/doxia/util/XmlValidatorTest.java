package org.apache.maven.doxia.util;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.doxia.logging.Log;
import org.apache.maven.doxia.logging.SystemStreamLog;
import org.codehaus.plexus.PlexusTestCase;
import org.codehaus.plexus.util.IOUtil;
import org.codehaus.plexus.util.xml.XmlStreamReader;

/**
 * Test case for <code>XmlValidator</code>.
 *
 * @author Hervé Boutemy
 * @version $Id: XmlValidatorTest.java 1721030 2015-12-20 14:25:19Z hboutemy $
 */
public class XmlValidatorTest
extends PlexusTestCase
{
    public void testValidate()
    throws Exception
    {
        String xml = IOUtil.toString( new XmlStreamReader( this.getClass().getResourceAsStream( "/test.xhtml" ) ) );

        Log log = new SystemStreamLog();
        XmlValidator validator = new XmlValidator( log );

        validator.validate( xml );
    }
}
