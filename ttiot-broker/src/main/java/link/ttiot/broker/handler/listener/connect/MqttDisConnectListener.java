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

package link.ttiot.broker.handler.listener.connect;

import link.ttiot.broker.eventor.connect.MqttDisConnectEvent;
import link.ttiot.common.context.protocal.mqtt.MqttApplicationListener;
import link.ttiot.common.context.service.MessageStoreService;
import link.ttiot.common.context.service.SessionService;
import link.ttiot.common.context.service.SubscribeService;
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
public class MqttDisConnectListener extends MqttApplicationListener<MqttDisConnectEvent> {

    @Inject
    private SessionService sessionService;

    @Inject
    private SubscribeService subscribeService;

    @Inject
    private MessageStoreService messageStoreService;

    public MqttDisConnectListener() {
        super();
    }

    @Override
    public void onApplicationEvent(MqttDisConnectEvent mqttDisConnectEvent) {

        log.info("The client requests the link to close , clientId: {}", mqttDisConnectEvent.getClientId());
        sessionService.delete(mqttDisConnectEvent.getClientId());

        getTTIotContext().removeChannelByContext(mqttDisConnectEvent.getClientId(),sessionService,()->{
            subscribeService.delete(mqttDisConnectEvent.getClientId());
            messageStoreService.deleteByClientId(mqttDisConnectEvent.getClientId());
        });
        mqttDisConnectEvent.getChannel().close();
    }

}
