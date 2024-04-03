/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.expensio.common.data.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Loginlogs service. Represents a row in the &quot;expensio_Loginlogs&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LoginlogsModel
 * @generated
 */
@ImplementationClassName("com.expensio.common.data.model.impl.LoginlogsImpl")
@ProviderType
public interface Loginlogs extends LoginlogsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.expensio.common.data.model.impl.LoginlogsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Loginlogs, Long> LOGIN_LOG_ID_ACCESSOR =
		new Accessor<Loginlogs, Long>() {

			@Override
			public Long get(Loginlogs loginlogs) {
				return loginlogs.getLoginLogId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Loginlogs> getTypeClass() {
				return Loginlogs.class;
			}

		};

}