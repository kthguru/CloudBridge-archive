/*
 * Copyright 2011 Cloud.com, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloud.bridge.service.core.s3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class S3PolicyConditionBlock {
	
	private List<S3PolicyCondition> conditionList = new ArrayList<S3PolicyCondition>();
	public int nesting;
	
	public S3PolicyConditionBlock() {
	}

	public S3PolicyCondition[] getBlock() {
		return conditionList.toArray(new S3PolicyCondition[0]);
	}
	
	public void addCondition(S3PolicyCondition param) {
		conditionList.add( param );
	}
	
	public String toString() {
		
		StringBuffer value = new StringBuffer();
		Iterator<S3PolicyCondition> itr = conditionList.iterator();
		
		value.append( "Condition: \n" );
		while( itr.hasNext()) {
			S3PolicyCondition oneCondition = itr.next();
			value.append( oneCondition.toString());
		}
		
		return value.toString();
	}
}