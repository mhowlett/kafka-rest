/*
 * Copyright 2017 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.confluent.kafkarest.extension;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import io.confluent.kafkarest.KafkaRestContext;


public class ContextInvocationHandler implements InvocationHandler {

  public ContextInvocationHandler() {
  }

  private KafkaRestContext getContext() {
    return KafkaRestContextProvider.getContext();
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    KafkaRestContext context = getContext();
    return method.invoke(context, args);
  }
}