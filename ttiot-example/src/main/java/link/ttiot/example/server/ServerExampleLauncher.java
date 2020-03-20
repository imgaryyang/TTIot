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

package link.ttiot.example.server;


import link.ttiot.broker.db.redis.RedisDbHelper;
import link.ttiot.broker.start.ServerLauncher;
import link.ttiot.common.redis.RedisSourceProvider;
import link.ttiot.example.server.exception.ExceptionHandlerDemo;

/**
 * @author: shijun
 * @date: 2019-05-05
 * @description:
 */
public class ServerExampleLauncher {

    public static void main(String[] args) {
        new ServerLauncher().dbHelper(new RedisDbHelper(new RedisSourceProvider())).exceptionHandler(new ExceptionHandlerDemo()).launch();
    }


}
