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

package link.ttiot.broker.handler.listener.publish.comp;

import io.netty.handler.codec.mqtt.MqttMessageIdVariableHeader;
import link.ttiot.broker.eventor.publish.comp.MqttPubCompEvent;
import link.ttiot.common.context.protocal.mqtt.MqttApplicationListener;
import link.ttiot.common.context.service.MessageStoreService;
import link.ttiot.common.core.function.FunctionApi;
import link.ttiot.common.ioc.annotation.DefaultListener;
import link.ttiot.common.ioc.annotation.Inject;
import lombok.extern.slf4j.Slf4j;


/**
 * @author: shijun
 * @date: 2019-04-12
 * @description:
 */
@Slf4j
@DefaultListener
public class MqttPubCompListener extends MqttApplicationListener<MqttPubCompEvent> implements FunctionApi {

    @Inject
    private MessageStoreService messageStoreService;

    public MqttPubCompListener() {
        super();
    }

    @Override
    public void onApplicationEvent(MqttPubCompEvent mqttPubCompEvent) {

        MqttMessageIdVariableHeader mqttMessageIdVariableHeader = (MqttMessageIdVariableHeader)mqttPubCompEvent.getSource().variableHeader();

        messageStoreService.delete(mqttMessageIdVariableHeader.messageId(),mqttPubCompEvent.getClientId());

    }


}
