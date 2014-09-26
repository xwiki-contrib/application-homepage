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
package org.xwiki.contrib.homepage.test.po;

import org.xwiki.test.ui.po.ViewPage;

/**
 * Represents the actions possible on the Home Page.
 * 
 * @version $Id: c7ef05ca01780703ce56966dfc2a5f430ab01773 $
 * @since 6.2M1
 */
public class HomePage extends ViewPage
{
    /**
     * The part of the home page that lists the existing spaces and allows the user to create a new space.
     */
    private final SpacesPane spacesPane = new SpacesPane();

    public static HomePage gotoPage()
    {
        getUtil().gotoPage("Main", "WebHome");
        return new HomePage();
    }

    public String getURL()
    {
        return getUtil().getURL("Main", "WebHome");
    }

    public boolean isOnHomePage()
    {
        return getDriver().getCurrentUrl().equals(getURL());
    }

    /**
     * @return the part of the home page that lists the existing spaces and allows the user to create a new space
     */
    public SpacesPane getSpacesPane()
    {
        return spacesPane;
    }
}
