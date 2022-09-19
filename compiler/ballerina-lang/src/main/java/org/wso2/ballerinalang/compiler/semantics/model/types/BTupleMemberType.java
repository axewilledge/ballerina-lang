/*
 *  Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wso2.ballerinalang.compiler.semantics.model.types;

import org.wso2.ballerinalang.compiler.semantics.model.symbols.BVarSymbol;

/**
 * {@code {@link BTupleMemberType }} represents a member in a tuple.
 *
 */
public class BTupleMemberType {

    public BType type;
    public BVarSymbol symbol;

    public BTupleMemberType(BType type, BVarSymbol symbol) {
        this.type = type;
        this.symbol = symbol;
    }

    public BTupleMemberType(BType type) {
        this.type = type;
        this.symbol = new BVarSymbol(type.flags, null, null, type, null, null, null);
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
