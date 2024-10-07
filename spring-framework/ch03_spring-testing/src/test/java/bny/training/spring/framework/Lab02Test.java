/*
 * Copyright 2024 The Bank of New York Mellon.
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

package bny.training.spring.framework;

import bny.training.spring.framework.model.BulkVehicleOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:/lab02.xml"})
public class Lab02Test {

  @Autowired
  private BulkVehicleOrder bulkVehicleOrder;

  @Test
  public void customXmlContextPath() {
    
    assertEquals(
        7,
        bulkVehicleOrder.getQuantity(),
        "The quantity of vehicles should be [7]"
    );

    assertEquals(
        "2016 pickup",
        bulkVehicleOrder.getVehicle().toString(),
        "The shape should be [2016 pickup]"
    );
  }
}
