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
 * Document objet model: we parse the document to a bunch of these.
 * <p/>
 * Implementators should implement equals() and hashCode() to ease testing
 *
 * @author Juan F. Codagnone
 * @version $Id: Block.java 705065 2008-10-15 21:46:08Z vsiveton $
 */
public interface Block
{
    /**
     * Traverse the block
     *
     * @param sink the sink that travers
     */
    void traverse( final Sink sink );
}
