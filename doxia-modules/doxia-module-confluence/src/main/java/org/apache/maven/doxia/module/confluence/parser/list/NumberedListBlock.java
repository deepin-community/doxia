package org.apache.maven.doxia.module.confluence.parser.list;

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

import org.apache.maven.doxia.module.confluence.parser.Block;
import org.apache.maven.doxia.sink.Sink;

import java.util.List;

/**
 * <p>NumberedListBlock class.</p>
 *
 * @version $Id: NumberedListBlock.java 1090706 2011-04-09 23:15:28Z hboutemy $
 */
public class NumberedListBlock
    extends ListBlock
{
    /**
     * @param childBlocks
     */
    NumberedListBlock( List<Block> childBlocks )
    {
        super( childBlocks );
    }

    /** {@inheritDoc} */
    public void before( Sink sink )
    {
        sink.numberedList( Sink.NUMBERING_DECIMAL );
    }

    /** {@inheritDoc} */
    public void after( Sink sink )
    {
        sink.numberedList_();
    }
}
