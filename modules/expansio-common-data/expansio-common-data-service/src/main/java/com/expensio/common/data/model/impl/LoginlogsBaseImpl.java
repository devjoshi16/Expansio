/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.expensio.common.data.model.impl;

import com.expensio.common.data.model.Loginlogs;
import com.expensio.common.data.service.LoginlogsLocalServiceUtil;

/**
 * The extended model base implementation for the Loginlogs service. Represents a row in the &quot;expensio_Loginlogs&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LoginlogsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoginlogsImpl
 * @see Loginlogs
 * @generated
 */
public abstract class LoginlogsBaseImpl
	extends LoginlogsModelImpl implements Loginlogs {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a loginlogs model instance should use the <code>Loginlogs</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			LoginlogsLocalServiceUtil.addLoginlogs(this);
		}
		else {
			LoginlogsLocalServiceUtil.updateLoginlogs(this);
		}
	}

}