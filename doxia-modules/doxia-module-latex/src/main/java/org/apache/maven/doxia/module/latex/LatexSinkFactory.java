package org.apache.maven.doxia.module.latex;

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

import java.io.Writer;

import org.apache.maven.doxia.sink.Sink;
import org.apache.maven.doxia.sink.SinkFactory;
import org.apache.maven.doxia.sink.impl.AbstractTextSinkFactory;
import org.codehaus.plexus.component.annotations.Component;

/**
 * Latex implementation of the Sink factory.
 *
 * @author <a href="mailto:vincent.siveton@gmail.com">Vincent Siveton</a>
 * @version $Id: LatexSinkFactory.java 1726411 2016-01-23 16:34:09Z hboutemy $
 * @since 1.0
 */
@Component( role = SinkFactory.class, hint = "latex" )
public class LatexSinkFactory
    extends AbstractTextSinkFactory
{
    /** {@inheritDoc} */
    protected Sink createSink( Writer writer, String encoding )
    {
        // TODO: can encoding safely be ignored? Shouldn't it be written into the generated Latex source
        // as inputenc package parameter?
        return new LatexSink( writer );
    }
}
