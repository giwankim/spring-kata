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

package bny.training.spring.framework.annotation;

import bny.training.spring.framework.model.ConstructorAnnotatedBulkVehicleOrder;
import bny.training.spring.framework.model.ConstructorAnnotatedWithQualifierBulkVehicleOrder;
import bny.training.spring.framework.model.SetterAnnotatedBulkVehicleOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Refer to the bny.training.spring.framework.annotation package in the examples.
public class Lab02Test {

  private ApplicationContext context;

  @BeforeEach
  public void setup() {

  }

  @Test
  public void injectThroughSetterAnnotation() {
    context = new ClassPathXmlApplicationContext("test-inject-with-annotations1.xml");

    SetterAnnotatedBulkVehicleOrder setterAnnotatedBulkVehicleOrder =
        (SetterAnnotatedBulkVehicleOrder) context.getBean("setterAnnotatedBulkVehicleOrder");
    assertEquals(
        "1 count of 2017 car",
        setterAnnotatedBulkVehicleOrder.toString(),
        "The order should be: 1 count of 2017 car"
    );
  }

  @Test
  public void injectThroughConstructor() {
    context = new ClassPathXmlApplicationContext("test-inject-with-annotations2.xml");

    ConstructorAnnotatedBulkVehicleOrder constructorAnnotatedBulkVehicleOrder =
        (ConstructorAnnotatedBulkVehicleOrder) context.getBean("constructorAnnotatedBulkVehicleOrder");
    assertEquals(
        "5 count of 2016 truck",
        constructorAnnotatedBulkVehicleOrder.toString(),
        "The order should be: 5 count of 2016 truck"
    );
  }

  @Test
  public void injectThroughConstructorWithQualifier() {
    context = new ClassPathXmlApplicationContext("test-inject-with-annotations3.xml");
    
    ConstructorAnnotatedWithQualifierBulkVehicleOrder constructorAnnotatedWithQualifierBulkVehicleOrder =
        (ConstructorAnnotatedWithQualifierBulkVehicleOrder) context.getBean("constructorAnnotatedWithQualifierBulkVehicleOrder");
    assertEquals(
        "7 count of 2014 airplane",
        constructorAnnotatedWithQualifierBulkVehicleOrder.toString(),
        "The order should be: 7 count of 2014 airplane"
    );
  }
}
