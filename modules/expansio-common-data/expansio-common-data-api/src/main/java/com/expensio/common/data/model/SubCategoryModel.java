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
 * The base model interface for the SubCategory service. Represents a row in the &quot;expensio_SubCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.expensio.common.data.model.impl.SubCategoryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.expensio.common.data.model.impl.SubCategoryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubCategory
 * @generated
 */
@ProviderType
public interface SubCategoryModel
	extends BaseModel<SubCategory>, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a sub category model instance should use the {@link SubCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this sub category.
	 *
	 * @return the primary key of this sub category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this sub category.
	 *
	 * @param primaryKey the primary key of this sub category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this sub category.
	 *
	 * @return the uuid of this sub category
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this sub category.
	 *
	 * @param uuid the uuid of this sub category
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the sub category ID of this sub category.
	 *
	 * @return the sub category ID of this sub category
	 */
	public long getSubCategoryId();

	/**
	 * Sets the sub category ID of this sub category.
	 *
	 * @param subCategoryId the sub category ID of this sub category
	 */
	public void setSubCategoryId(long subCategoryId);

	/**
	 * Returns the company ID of this sub category.
	 *
	 * @return the company ID of this sub category
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this sub category.
	 *
	 * @param companyId the company ID of this sub category
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this sub category.
	 *
	 * @return the user ID of this sub category
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this sub category.
	 *
	 * @param userId the user ID of this sub category
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this sub category.
	 *
	 * @return the user uuid of this sub category
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this sub category.
	 *
	 * @param userUuid the user uuid of this sub category
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this sub category.
	 *
	 * @return the user name of this sub category
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this sub category.
	 *
	 * @param userName the user name of this sub category
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this sub category.
	 *
	 * @return the create date of this sub category
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this sub category.
	 *
	 * @param createDate the create date of this sub category
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this sub category.
	 *
	 * @return the modified date of this sub category
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this sub category.
	 *
	 * @param modifiedDate the modified date of this sub category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the sub category name of this sub category.
	 *
	 * @return the sub category name of this sub category
	 */
	@AutoEscape
	public String getSubCategoryName();

	/**
	 * Sets the sub category name of this sub category.
	 *
	 * @param subCategoryName the sub category name of this sub category
	 */
	public void setSubCategoryName(String subCategoryName);

	/**
	 * Returns the category ID of this sub category.
	 *
	 * @return the category ID of this sub category
	 */
	public Long getCategoryId();

	/**
	 * Sets the category ID of this sub category.
	 *
	 * @param categoryId the category ID of this sub category
	 */
	public void setCategoryId(Long categoryId);

	@Override
	public SubCategory cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}