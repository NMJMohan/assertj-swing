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
package org.assertj.swing.driver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.query.ComponentSizeQuery.sizeOf;

import javax.swing.JInternalFrame;

import org.assertj.swing.annotation.RunsInEDT;
import org.junit.Test;

/**
 * Tests for {@link JInternalFrameDriver#resizeHeight(JInternalFrame, int)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class JInternalFrameDriver_resizeHeightTo_Test extends JInternalFrameDriver_TestCase {
  @Test
  public void should_Resize_Height() {
    showWindow();
    int newHeight = 600;
    assertThat(heightOf(internalFrame)).isNotEqualTo(newHeight);
    driver.resizeHeight(internalFrame, newHeight);
    assertThat(heightOf(internalFrame)).isEqualTo(newHeight);
  }

  @RunsInEDT
  private static int heightOf(JInternalFrame internalFrame) {
    return sizeOf(internalFrame).height;
  }
}
