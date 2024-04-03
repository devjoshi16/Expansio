/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.expensio.common.data.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Designations service. Represents a row in the &quot;expensio_Designations&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.expensio.common.data.model.impl.DesignationsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.expensio.common.data.model.impl.DesignationsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Designations
 * @generated
 */
@ProviderType
public interface DesignationsModel
	extends BaseModel<Designations>, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a designations model instance should use the {@link Designations} interface instead.
	 */

	/**
	 * Returns the primary key of this designations.
	 *
	 * @return the primary key of this designations
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this designations.
	 *
	 * @param primaryKey the primary key of this designations
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this designations.
	 *
	 * @return the uuid of this designations
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this designations.
	 *
	 * @param uuid the uuid of this designations
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the designation ID of this designations.
	 *
	 * @return the designation ID of this designations
	 */
	public long getDesignationId();

	/**
	 * Sets the designation ID of this designations.
	 *
	 * @param designationId the designation ID of this designations
	 */
	public void setDesignationId(long designationId);

	/**
	 * Returns the company ID of this designations.
	 *
	 * @return the company ID of this designations
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this designations.
	 *
	 * @param companyId the company ID of this designations
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this designations.
	 *
	 * @return the user ID of this designations
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this designations.
	 *
	 * @param userId the user ID of this designations
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this designations.
	 *
	 * @return the user uuid of this designations
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this designations.
	 *
	 * @param userUuid the user uuid of this designations
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this designations.
	 *
	 * @return the user name of this designations
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this designations.
	 *
	 * @param userName the user name of this designations
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this designations.
	 *
	 * @return the create date of this designations
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this designations.
	 *
	 * @param createDate the create date of this designations
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this designations.
	 *
	 * @return the modified date of this designations
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this designations.
	 *
	 * @param modifiedDate the modified date of this designations
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the designation name of this designations.
	 *
	 * @return the designation name of this designations
	 */
	@AutoEscape
	public String getDesignationName();

	/**
	 * Sets the designation name of this designations.
	 *
	 * @param designationName the designation name of this designations
	 */
	public void setDesignationName(String designationName);

	/**
	 * Returns the department ID of this designations.
	 *
	 * @return the department ID of this designations
	 */
	public Long getDepartmentId();

	/**
	 * Sets the department ID of this designations.
	 *
	 * @param departmentId the department ID of this designations
	 */
	public void setDepartmentId(Long departmentId);

	@Override
	public Designations cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}