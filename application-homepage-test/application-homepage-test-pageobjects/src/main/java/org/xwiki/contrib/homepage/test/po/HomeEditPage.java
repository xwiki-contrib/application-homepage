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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.xwiki.test.ui.po.InlinePage;
import org.xwiki.test.ui.po.LiveTableElement;

/**
 * Represents a Home PAge being edited.
 *
 * @version $Id: 6b749eae0842d8350e14d3c8d4dc98b9c65713ed $
 * @since 6.2M1
 */
public class HomeEditPage extends InlinePage
{
    @FindBy(id = "content")
    private WebElement customContentElement;

    /**
     * @param content the custom content to type in the page
     */
    public void setCustomContent(String content)
    {
        this.customContentElement.clear();
        this.customContentElement.sendKeys(content);
    }

    public void usePageAsHomePage(String spaceName)
    {
        LiveTableElement liveTableElement = new LiveTableElement("documents");
        liveTableElement.waitUntilReady();
        liveTableElement.filterColumn("xwiki-livetable-documents-filter-2", spaceName);
        WebElement rowElement = liveTableElement.getRow(0);

    }
}
