/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.camunda.bpm.engine.test.api.runtime.migration.util;

/**
 * @author Thorben Lindhauer
 *
 */
public interface MigratingBpmnEventTrigger extends BpmnEventTrigger, MigratingBpmnEventTriggerAssert {

  /**
   * Returns a new trigger that triggers the same event in the context of a different activity (e.g. because the activity has changed during migration)
   */
  MigratingBpmnEventTrigger inContextOf(String activityId);
}
