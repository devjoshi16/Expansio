/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.expensio.common.data.service.base;

import com.expensio.common.data.model.Employees;
import com.expensio.common.data.service.EmployeesService;
import com.expensio.common.data.service.EmployeesServiceUtil;
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
 * Provides the base implementation for the employees remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.expensio.common.data.service.impl.EmployeesServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.expensio.common.data.service.impl.EmployeesServiceImpl
 * @generated
 */
public abstract class EmployeesServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, EmployeesService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EmployeesService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>EmployeesServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		EmployeesServiceUtil.setService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EmployeesService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		employeesService = (EmployeesService)aopProxy;

		EmployeesServiceUtil.setService(employeesService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EmployeesService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Employees.class;
	}

	protected String getModelClassName() {
		return Employees.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = employeesPersistence.getDataSource();

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
	protected com.expensio.common.data.service.EmployeesLocalService
		employeesLocalService;

	protected EmployeesService employeesService;

	@Reference
	protected EmployeesPersistence employeesPersistence;

	@Reference
	protected ExpensesPersistence expensesPersistence;

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
		EmployeesServiceBaseImpl.class);

}