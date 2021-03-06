/**
 * Copyright Microsoft Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.microsoft.windowsazure.management.compute;

import com.microsoft.windowsazure.management.compute.models.VirtualMachineExtensionListResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class VirtualMachineExtensionOperationsTests extends ComputeManagementIntegrationTestBase {
    @BeforeClass
    public static void setup() throws Exception {
        createComputeManagementClient();
    }

    @Before
    public void beforeTest() throws Exception {
        setupTest();
    }
    
    @After
    public void afterTest() throws Exception {
        resetTest();
    }
    
    @Test
    public void listVirtualMachineExtensionSuccess() throws Exception {        
        VirtualMachineExtensionListResponse virtualMachineExtensionListResponse = computeManagementClient.getVirtualMachineExtensionsOperations().list();
        ArrayList<VirtualMachineExtensionListResponse.ResourceExtension> virtualMachineExtensionResourceExtensionlist = virtualMachineExtensionListResponse.getResourceExtensions();
        Assert.assertNotNull(virtualMachineExtensionResourceExtensionlist);
        assertTrue(virtualMachineExtensionResourceExtensionlist.size() > 0);
    }

    @Test
    public void listVirtualMachineExtensionVersionSuccess() throws Exception {
        //Arrange
        String publisherName = "BGInfo";
        String extensionName = "BGInfo";
        //Act
        VirtualMachineExtensionListResponse virtualMachineExtensionListResponse = computeManagementClient.getVirtualMachineExtensionsOperations().listVersions(publisherName, extensionName);
        ArrayList<VirtualMachineExtensionListResponse.ResourceExtension> virtualMachineExtensionResourceExtensionlist = virtualMachineExtensionListResponse.getResourceExtensions();
        Assert.assertNotNull(virtualMachineExtensionResourceExtensionlist);
   }
}