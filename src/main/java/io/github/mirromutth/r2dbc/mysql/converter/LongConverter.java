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

package io.github.mirromutth.r2dbc.mysql.converter;

import io.github.mirromutth.r2dbc.mysql.constant.ColumnType;
import io.github.mirromutth.r2dbc.mysql.core.MySqlSession;
import io.netty.buffer.ByteBuf;

/**
 * Converter for {@link long}.
 */
final class LongConverter extends AbstractPrimitiveConverter<Long> {

    static final LongConverter INSTANCE = new LongConverter();

    private LongConverter() {
        super(Long.TYPE, Long.class);
    }

    @Override
    public Long read(ByteBuf buf, boolean isUnsigned, int precision, int collationId, Class<? super Long> target, MySqlSession session) {
        // TODO: implement this method
        throw new IllegalStateException();
    }

    @Override
    boolean doCanRead(ColumnType type, boolean isUnsigned, int precision) {
        if (isUnsigned) {
            return ColumnType.INT == type;
        } else {
            return ColumnType.BIGINT == type;
        }
    }
}
