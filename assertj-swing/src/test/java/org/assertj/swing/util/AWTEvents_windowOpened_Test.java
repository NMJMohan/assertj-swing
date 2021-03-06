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

import static java.awt.event.WindowEvent.WINDOW_CLOSING;
import static java.awt.event.WindowEvent.WINDOW_OPENED;
import static org.assertj.core.api.Assertions.assertThat;

import java.awt.AWTEvent;
import java.awt.event.WindowEvent;

import org.assertj.swing.test.core.SequentialEDTSafeTestCase;
import org.assertj.swing.test.swing.TestWindow;
import org.junit.Test;

/**
 * Tests for {@link AWTEvents#wasWindowOpened(java.awt.AWTEvent)}.
 * 
 * @author Alex Ruiz
 */
public class AWTEvents_windowOpened_Test extends SequentialEDTSafeTestCase {
  private TestWindow source;

  @Override
  protected void onSetUp() {
    source = TestWindow.createNewWindow(getClass());
  }

  @Override
  protected void onTearDown() {
    source.destroy();
  }

  @Test
  public void should_Return_True_If_Window_Opened() {
    AWTEvent event = new WindowEvent(source, WINDOW_OPENED);
    assertThat(AWTEvents.wasWindowOpened(event)).isTrue();
  }

  @Test
  public void should_Return_False_If_Window_Not_Opened() {
    AWTEvent event = new WindowEvent(source, WINDOW_CLOSING);
    assertThat(AWTEvents.wasWindowOpened(event)).isFalse();
  }
}
