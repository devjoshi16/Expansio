/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.expensio.data.service.impl;

import com.expensio.data.service.base.login_logsServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=expensio",
		"json.web.service.context.path=login_logs"
	},
	service = AopService.class
)
public class login_logsServiceImpl extends login_logsServiceBaseImpl {
}