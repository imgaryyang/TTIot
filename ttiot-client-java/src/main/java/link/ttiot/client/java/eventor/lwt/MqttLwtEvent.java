/**
 * Copyright(c) link.ttiot & shijun All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Author: shijun (conttononline@outlook.com)
 */

package link.ttiot.client.java.eventor.lwt;

import link.ttiot.common.ioc.annotation.Eventor;
import link.ttiot.common.ioc.core.ApplicationEvent;


/**
 * @author: shijun
 * @date: 2019-04-15
 * @description:遗嘱事件
 */
@Eventor
public class MqttLwtEvent extends ApplicationEvent {

    public MqttLwtEvent(String clientId) {
        super(clientId);
    }

    @Override
    public String getSource() {
        return (String) source;
    }

}
