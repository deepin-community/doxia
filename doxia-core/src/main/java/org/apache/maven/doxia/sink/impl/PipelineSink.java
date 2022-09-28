package org.apache.maven.doxia.sink.impl;

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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import java.util.List;

import org.apache.maven.doxia.sink.Sink;

/**
 * May be used to invoke the same method on a List of Sinks.
 *
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l</a>
 * @version $Id: PipelineSink.java 1726411 2016-01-23 16:34:09Z hboutemy $
 */
public class PipelineSink
    implements InvocationHandler
{
    private List<Sink> pipeline;

    /**
     * Constructs a PipelineSink for a given List of Sinks.
     *
     * @param pipeline A List of Sinks.
     */
    public PipelineSink( List<Sink> pipeline )
    {
        this.pipeline = pipeline;
    }

    /**
     * Add a Sink to the List of Sinks.
     *
     * @param sink the Sink to add.
     */
    public void addSink( Sink sink )
    {
        pipeline.add( sink );
    }

    /**
     * {@inheritDoc}
     *
     * Invoke a Method on this PipelineSink.
     *
     * @throws IllegalAccessException if any.
     * @throws InvocationTargetException if any.
     */
    public Object invoke( Object proxy, Method method, Object[] args )
            throws IllegalAccessException, InvocationTargetException
    {
        for ( Sink sink : pipeline )
        {
            method.invoke( sink, args );
        }

        return null;
    }

    /**
     * Returns an instance of a PipelineSink as a Sink.
     *
     * @param pipeline A List of Sinks.
     * @return a {@link org.apache.maven.doxia.sink.Sink} object.
     */
    public static Sink newInstance( List<Sink> pipeline )
    {
        return (Sink) Proxy.newProxyInstance( PipelineSink.class.getClassLoader(),
                                              new Class<?>[]{Sink.class},
                                              new PipelineSink( pipeline ) );
    }
}