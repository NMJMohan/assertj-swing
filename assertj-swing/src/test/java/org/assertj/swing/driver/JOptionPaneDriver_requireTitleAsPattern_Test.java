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

import static org.assertj.swing.test.swing.JOptionPaneLauncher.pack;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.junit.Test;

/**
 * Tests for {@link JOptionPaneDriver#requireTitle(JOptionPane, java.util.regex.Pattern)}.
 * 
 * @author Alex Ruiz
 */
public class JOptionPaneDriver_requireTitleAsPattern_Test extends JOptionPaneDriver_TestCase {
  @Test
  public void should_Pass_If_Title_Matches_Pattern() {
    JOptionPane optionPane = informationMessage();
    pack(optionPane, title());
    driver.requireTitle(optionPane, Pattern.compile("JOptionP.*"));
  }

  @Test
  public void should_Fail_If_Title_Does_Not_Match_Pattern() {
    JOptionPane optionPane = informationMessage();
    pack(optionPane, title());
    thrown.expectAssertionError("title", title(), Pattern.compile("Yoda"));
    driver.requireTitle(optionPane, Pattern.compile("Yoda"));
  }
}
