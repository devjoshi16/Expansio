/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.expensio.common.data.service.base;

import com.expensio.common.data.model.Loginlogs;
import com.expensio.common.data.service.LoginlogsService;
import com.expensio.common.data.service.LoginlogsServiceUtil;
import com.expensio.common.data.service.persistence.BudgetsPersistence;
import com.expensio.common.data.service.persistence.CategoryPersistence;
import com.expensio.common.data.service.persistence.EmployeesPersistence;
import com.expensio.common.data.service.persistence.ExpensesPersistence;
import com.expensio.common.data.service.persistence.LoginlogsPersistence;
import com.expensio.common.data.service.persistence.SubCategoryPersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the loginlogs remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.expensio.common.data.service.impl.LoginlogsServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.expensio.common.data.service.impl.LoginlogsServiceImpl
 * @generated
 */
public abstract class LoginlogsServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, LoginlogsService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>LoginlogsService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>LoginlogsServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		LoginlogsServiceUtil.setService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			LoginlogsService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		loginlogsService = (LoginlogsService)aopProxy;

		LoginlogsServiceUtil.setService(loginlogsService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return LoginlogsService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Loginlogs.class;
	}

	protected String getModelClassName() {
		return Loginlogs.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = loginlogsPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected BudgetsPersistence budgetsPersistence;

	@Reference
	protected CategoryPersistence categoryPersistence;

	@Reference
	protected EmployeesPersistence employeesPersistence;

	@Reference
	protected ExpensesPersistence expensesPersistence;

	@Reference
	protected com.expensio.common.data.service.LoginlogsLocalService
		loginlogsLocalService;

	protected LoginlogsService loginlogsService;

	@Reference
	protected LoginlogsPersistence loginlogsPersistence;

	@Reference
	protected SubCategoryPersistence subCategoryPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	private static final Log _log = LogFactoryUtil.getLog(
		LoginlogsServiceBaseImpl.class);

}