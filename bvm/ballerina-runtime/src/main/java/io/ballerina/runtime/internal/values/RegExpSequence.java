/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
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
package io.ballerina.runtime.internal.values;

import io.ballerina.runtime.api.PredefinedTypes;
import io.ballerina.runtime.api.types.Type;
import io.ballerina.runtime.api.values.BLink;
import io.ballerina.runtime.api.values.BTypedesc;

import java.util.Map;
import java.util.StringJoiner;

/**
 * <p>
 * Represents an ReSequence in regular expression.
 * </p>
 * <p>
 * <i>Note: This is an internal API and may change in future versions.</i>
 * </p>
 *
 * @since 2201.3.0
 */
public class RegExpSequence implements RefValue {
    private RegExpTerm[] termsList;

    public RegExpSequence(ArrayValue termsList) {
        this.termsList = getRegExpSeqList(termsList);
    }

    public RegExpSequence(RegExpTerm[] termsList) {
        this.termsList = termsList;
    }

    public RegExpTerm[] getRegExpTermsList() {
        return this.termsList;
    }

    private RegExpTerm[] getRegExpSeqList(ArrayValue seqList) {
        int size = seqList.size();
        RegExpTerm[] terms = new RegExpTerm[size];
        for (int i = 0; i < size; i++) {
            terms[i] = (RegExpTerm) seqList.get(i);
        }
        return terms;
    }

    @Override
    public String stringValue(BLink parent) {
        StringJoiner terms = new StringJoiner("");
        for (RegExpTerm t : this.termsList) {
            terms.add(t.stringValue(parent));
        }
        return terms.toString();
    }

    @Override
    public String expressionStringValue(BLink parent) {
        return stringValue(parent);
    }

    @Override
    public String informalStringValue(BLink parent) {
        return stringValue(parent);
    }

    @Override
    public Type getType() {
        return PredefinedTypes.TYPE_ANYDATA;
    }

    @Override
    public Object copy(Map<Object, Object> refs) {
        return this;
    }

    @Override
    public Object frozenCopy(Map<Object, Object> refs) {
        return this;
    }

    @Override
    public BTypedesc getTypedesc() {
        throw new UnsupportedOperationException();
    }
}
