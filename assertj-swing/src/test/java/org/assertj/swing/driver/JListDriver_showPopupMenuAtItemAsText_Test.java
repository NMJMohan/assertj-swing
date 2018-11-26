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
import static org.assertj.swing.core.MouseButton.RIGHT_BUTTON;
import static org.assertj.swing.query.ComponentVisibleQuery.isVisible;

import org.assertj.swing.test.recorder.ClickRecorderManager;
import org.assertj.swing.test.recorder.ToolkitClickRecorder;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link JListDriver#showPopupMenu(javax.swing.JList, String)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class JListDriver_showPopupMenuAtItemAsText_Test extends JListDriver_showPopupMenu_TestCase {
  @Rule
  public ClickRecorderManager clickRecorder = new ClickRecorderManager();

  @Test
  public void should_Show_Popup_Menu_At_Item_With_Given_Value() {
    showWindow();
    driver.click(list);
    ToolkitClickRecorder recorder = clickRecorder.attachToToolkitFor(list);
    driver.showPopupMenu(list, "one");
    recorder.clicked(RIGHT_BUTTON);
    assertThat(isVisible(popupMenu)).isTrue();
    assertThat(locationToIndex(recorder.pointClicked())).isEqualTo(0);
    assertThatCellReaderWasCalled();
  }

  @Test
  public void should_Show_Popup_Menu_At_Item_Matching_Pattern() {
    showWindow();
    driver.click(list);
    ToolkitClickRecorder recorder = clickRecorder.attachToToolkitFor(list);
    driver.showPopupMenu(list, "o.*");
    recorder.clicked(RIGHT_BUTTON);
    assertThat(isVisible(popupMenu)).isTrue();
    assertThat(locationToIndex(recorder.pointClicked())).isEqualTo(0);
    assertThatCellReaderWasCalled();
  }

  @Test
  public void should_Throw_Error_If_JList_Is_Disabled() {
    disableList();
    thrown.expectIllegalStateIsDisabledComponent();
    driver.showPopupMenu(list, "o.*");
  }

  @Test
  public void should_Throw_Error_If_JList_Is_Not_Showing_On_The_Screen() {
    thrown.expectIllegalStateIsNotShowingComponent();
    driver.showPopupMenu(list, "o.*");
  }
}
