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
package org.camunda.bpm.engine.test.bpmn.servicetask;

import java.util.Collections;
import java.util.Map;

import org.camunda.bpm.engine.ProcessEngineException;
import org.camunda.bpm.engine.impl.test.PluggableProcessEngineTestCase;
import org.camunda.bpm.engine.test.Deployment;

/**
 * @author Ronny Bräunlich
 *
 */
public class ServiceTaskExpressionActivityBehaviorTest extends PluggableProcessEngineTestCase {

  @Deployment
  public void testExceptionThrownBySecondServiceTaskIsNotHandled(){
    Map<Object, Object> beans = processEngineConfiguration.getBeans();
    beans.put("dummyServiceTask", new DummyServiceTask());
    beans.put("throwExceptionServiceTask", new ThrowExceptionServiceTask());
    processEngineConfiguration.setBeans(beans);

    try{
      runtimeService.startProcessInstanceByKey("process", Collections.<String, Object>singletonMap("count", 0));
      fail();
      // the EL resolver will wrap the actual exception inside a process engine exception
    } catch(ProcessEngineException e){}
  }

}
