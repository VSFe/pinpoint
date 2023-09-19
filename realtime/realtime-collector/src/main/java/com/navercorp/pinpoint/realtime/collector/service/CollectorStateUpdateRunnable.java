/*
 * Copyright 2023 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.navercorp.pinpoint.realtime.collector.service;

import com.navercorp.pinpoint.realtime.collector.dao.CollectorStateDao;
import com.navercorp.pinpoint.realtime.vo.CollectorState;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author youngjin.kim2
 */
public class CollectorStateUpdateRunnable implements Runnable {

    private final AgentConnectionRepository connectionRepository;
    private final CollectorStateDao dao;

    public CollectorStateUpdateRunnable(AgentConnectionRepository connectionRepository, CollectorStateDao dao) {
        this.connectionRepository = Objects.requireNonNull(connectionRepository, "connectionRepository");
        this.dao = Objects.requireNonNull(dao, "dao");
    }

    @Override
    public void run() {
        dao.update(getCollectorState());
    }

    private CollectorState getCollectorState() {
        return new CollectorState(new ArrayList<>(this.connectionRepository.getClusterKeys()));
    }

}
