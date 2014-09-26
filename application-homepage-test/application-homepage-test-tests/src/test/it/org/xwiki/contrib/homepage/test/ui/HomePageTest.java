/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.contrib.homepage.test.ui;

import static org.junit.Assert.*;

import org.junit.Test;
import org.xwiki.contrib.homepage.test.po.HomeEditPage;
import org.xwiki.contrib.homepage.test.po.HomePage;
import org.xwiki.test.ui.AbstractTest;
import org.xwiki.test.ui.po.ViewPage;

/**
 * Tests for editing the Home Page.
 * 
 * @version $Id: dbf8b94f73ed6ca43de9822d38474b2d2a790a65 $
 * @since 6.2M1
 */
public class HomePageTest extends AbstractTest
{
    @Test
    public void edit() throws Exception
    {
        // Create a test user
        getUtil().createUserAndLogin(getClass().getSimpleName() + "_" + getTestMethodName(), "password");

        // Navigate to the home page
        HomePage homePage = HomePage.gotoPage();

        // Test 1: Edit the home page and set some custom content
        homePage.edit();
        HomeEditPage editPage = new HomeEditPage();
        editPage.setCustomContent("custom content");
        ViewPage vp = editPage.clickSaveAndView();

        assertEquals("custom content", vp.getContent());

        // Test 2: Edit the home page and set a page to display, it should raise an error because we have custom
        // content. Click on the button to accept loosing the custom content.
        homePage.edit();
        editPage = new HomeEditPage();
        editPage.usePageAsHomePage("Dashboard");

    }
}
