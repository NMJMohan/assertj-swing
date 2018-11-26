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

import org.assertj.swing.cell.JTableCellWriter;
import org.junit.Test;

/**
 * Tests for {@link JTableTextComponentEditorCellWriter#startCellEditing(javax.swing.JTable, int, int)} and
 * {@link JTableTextComponentEditorCellWriter#cancelCellEditing(javax.swing.JTable, int, int)}.
 * 
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class JTableTextComponentEditorCellWriter_startCellEditing_cancelCellEditing_Test extends
    JTableCellWriter_startCellEditing_TestCase {
  @Override
  protected JTableCellWriter createWriter() {
    return new JTableTextComponentEditorCellWriter(robot);
  }

  @Test
  public void should_Start_And_Cancel_Cell_Editing() {
    int row = 0;
    int column = 3;
    assertThat(valueAt(row, column)).isEqualTo(5);
    writer.startCellEditing(table, row, column);
    writer.cancelCellEditing(table, row, column);
    assertThat(valueAt(row, column)).isEqualTo(5);
  }
}
