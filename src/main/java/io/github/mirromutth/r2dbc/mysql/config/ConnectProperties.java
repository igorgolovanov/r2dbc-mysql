/*
 * Copyright 2018-2019 the original author or authors.
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

package io.github.mirromutth.r2dbc.mysql.config;

import reactor.util.annotation.Nullable;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.github.mirromutth.r2dbc.mysql.util.AssertUtils.requireNonNull;

/**
 * MySQL connection configuration properties
 */
public class ConnectProperties {

    private final String host;

    private final int port;

    private final boolean useSsl;

    private final String username;

    private final String password;

    private final String database;

    public ConnectProperties(
        String host,
        int port,
        boolean useSsl,
        String username,
        @Nullable String password,
        @Nullable String database
    ) {
        this.host = requireNonNull(host, "host must not be null");
        this.port = port;
        this.useSsl = useSsl;
        this.username = requireNonNull(username, "username must not be null");
        this.password = password;

        if (database == null || database.isEmpty()) {
            this.database = "";
        } else {
            this.database = database; // or use `database.intern()`?
        }
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public boolean isUseSsl() {
        return useSsl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }
}
