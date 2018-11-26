/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.swing.util;

import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Tests for {@link PatternTextMatcher#PatternTextMatcher(java.util.regex.Pattern...)}.
 * 
 * @author Alex Ruiz
 */
public class PatternTextMatcher_constructor_Test {
  @Test(expected = NullPointerException.class)
  public void should_Throw_Error_If_Pattern_Array_Is_Null() {
    Pattern[] patterns = null;
    new PatternTextMatcher(patterns);
  }

  @Test(expected = IllegalArgumentException.class)
  public void should_Throw_Error_If_Pattern_Array_Is_Empty() {
    new PatternTextMatcher(new Pattern[0]);
  }
}
