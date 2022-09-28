package org.apache.maven.doxia.module.twiki.parser;

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

import org.apache.maven.doxia.sink.Sink;

/**
 * @author Juan F. Codagnone
 * @version $Id: ParagraphBlock.java 763762 2009-04-09 18:19:56Z ltheussl $
 */
class ParagraphBlock
    extends AbstractFatherBlock
{
    ParagraphBlock( final Block[] blocks )
    {
        super( blocks );
    }

    /** {@inheritDoc} */
    final void before( final Sink sink )
    {
        sink.paragraph();
    }

    /** {@inheritDoc} */
    final void after( final Sink sink )
    {
        sink.paragraph_();
    }
}
