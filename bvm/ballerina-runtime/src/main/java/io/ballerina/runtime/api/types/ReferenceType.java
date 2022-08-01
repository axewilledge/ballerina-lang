/*
*  Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package io.ballerina.runtime.api.types;

/**
 * {@code ReferenceType} represents a reference type in Ballerina runtime.
 * These include map, record, array, tuple, xml, json, etc. types.
 *
 * @since 2.0.0
 */
public interface ReferenceType extends Type {

    /**
     * Get the referred type of the type if it is a type-reference type.
     *
     * @return the referred type
     */
    default Type getReferredType() {
        return this;
    }
}
