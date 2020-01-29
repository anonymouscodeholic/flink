/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.apache.flink.api.connector.source;

import org.apache.flink.annotation.Public;
import org.apache.flink.metrics.MetricGroup;

import java.util.concurrent.CompletableFuture;

/**
 * The class that expose some context from runtime to the {@link SourceReader}.
 */
@Public
public interface SourceReaderContext {

	/**
	 * @return The metric group this source belongs to.
	 */
	MetricGroup metricGroup();

	/**
	 * Send a source event to the source coordinator.
	 *
	 * @param sourceEvent the source event to coordinator.
	 * @return a completable future which will be completed either the event has been successfully sent
	 * or failed.
	 */
	CompletableFuture<Boolean> sendSourceEventToCoordinator(SourceEvent sourceEvent);
}