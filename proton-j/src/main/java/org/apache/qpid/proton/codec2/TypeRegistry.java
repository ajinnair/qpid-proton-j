/*
 *
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
 *
 */
package org.apache.qpid.proton.codec2;

import java.util.HashMap;
import java.util.Map;

public class TypeRegistry
{
    private static Map<String, PerformativeFactory> _typeRegByStrCode = new HashMap<String, PerformativeFactory>();

    private static Map<Long, PerformativeFactory> _typeRegByLongCode = new HashMap<Long, PerformativeFactory>();

    public static void registerType(long longCode, String strCode, PerformativeFactory factory)
    {
        _typeRegByStrCode.put(strCode, factory);
        _typeRegByLongCode.put(longCode, factory);
    }

    public static PerformativeFactory lookup(Object code)
    {
        if (code instanceof Long)
        {
            return lookup((Long) code);
        }
        else if (code instanceof String)
        {
            return lookup((String) code);
        }
        else
        {
            return null;
        }
    }

    static PerformativeFactory lookup(long code)
    {
        return _typeRegByLongCode.get(code);
    }

    static PerformativeFactory lookup(String code)
    {
        return _typeRegByStrCode.get(code);
    }
}