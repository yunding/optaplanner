/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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

package org.optaplanner.persistence.jaxb.api.score.buildin.simplebigdecimal;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.junit.Test;
import org.optaplanner.core.api.score.buildin.simplebigdecimal.SimpleBigDecimalScore;
import org.optaplanner.persistence.jaxb.api.score.AbstractScoreJaxbXmlAdapterTest;

import static org.junit.Assert.*;

public class SimpleBigDecimalScoreJaxbXmlAdapterTest extends AbstractScoreJaxbXmlAdapterTest {

    @Test
    public void serializeAndDeserialize() {
        assertSerializeAndDeserialize(null, new TestSimpleBigDecimalScoreWrapper(null));
        SimpleBigDecimalScore score = SimpleBigDecimalScore.valueOfInitialized(new BigDecimal("1234.4321"));
        assertSerializeAndDeserialize(score, new TestSimpleBigDecimalScoreWrapper(score));
        score = SimpleBigDecimalScore.valueOf(-7, new BigDecimal("1234.4321"));
        assertSerializeAndDeserialize(score, new TestSimpleBigDecimalScoreWrapper(score));
    }

    @XmlRootElement
    public static class TestSimpleBigDecimalScoreWrapper extends TestScoreWrapper<SimpleBigDecimalScore> {

        @XmlJavaTypeAdapter(SimpleBigDecimalScoreJaxbXmlAdapter.class)
        private SimpleBigDecimalScore score;

        @SuppressWarnings("unused")
        private TestSimpleBigDecimalScoreWrapper() {
        }

        public TestSimpleBigDecimalScoreWrapper(SimpleBigDecimalScore score) {
            this.score = score;
        }

        @Override
        public SimpleBigDecimalScore getScore() {
            return score;
        }

    }

}