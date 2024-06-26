/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.expensio.common.data.model.impl;

import com.expensio.common.data.model.Category;
import com.expensio.common.data.model.CategoryModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Category service. Represents a row in the &quot;expensio_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CategoryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CategoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryImpl
 * @generated
 */
@JSON(strict = true)
public class CategoryModelImpl
	extends BaseModelImpl<Category> implements CategoryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a category model instance should use the <code>Category</code> interface instead.
	 */
	public static final String TABLE_NAME = "expensio_Category";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"categoryId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"categoryName", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("categoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("categoryName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table expensio_Category (uuid_ VARCHAR(75) null,categoryId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,categoryName VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table expensio_Category";

	public static final String ORDER_BY_JPQL =
		" ORDER BY category.categoryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY expensio_Category.categoryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CATEGORYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public CategoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _categoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _categoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Category.class;
	}

	@Override
	public String getModelClassName() {
		return Category.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Category, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Category, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Category, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Category)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Category, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Category, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Category)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Category, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Category, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Category, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Category, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Category, Object>>();

			attributeGetterFunctions.put("uuid", Category::getUuid);
			attributeGetterFunctions.put("categoryId", Category::getCategoryId);
			attributeGetterFunctions.put("companyId", Category::getCompanyId);
			attributeGetterFunctions.put("userId", Category::getUserId);
			attributeGetterFunctions.put("userName", Category::getUserName);
			attributeGetterFunctions.put("createDate", Category::getCreateDate);
			attributeGetterFunctions.put(
				"modifiedDate", Category::getModifiedDate);
			attributeGetterFunctions.put(
				"categoryName", Category::getCategoryName);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Category, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Category, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Category, ?>>();

			attributeSetterBiConsumers.put(
				"uuid", (BiConsumer<Category, String>)Category::setUuid);
			attributeSetterBiConsumers.put(
				"categoryId",
				(BiConsumer<Category, Long>)Category::setCategoryId);
			attributeSetterBiConsumers.put(
				"companyId",
				(BiConsumer<Category, Long>)Category::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId", (BiConsumer<Category, Long>)Category::setUserId);
			attributeSetterBiConsumers.put(
				"userName",
				(BiConsumer<Category, String>)Category::setUserName);
			attributeSetterBiConsumers.put(
				"createDate",
				(BiConsumer<Category, Date>)Category::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate",
				(BiConsumer<Category, Date>)Category::setModifiedDate);
			attributeSetterBiConsumers.put(
				"categoryName",
				(BiConsumer<Category, String>)Category::setCategoryName);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_categoryId = categoryId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getCategoryName() {
		if (_categoryName == null) {
			return "";
		}
		else {
			return _categoryName;
		}
	}

	@Override
	public void setCategoryName(String categoryName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_categoryName = categoryName;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Category.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Category.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Category toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Category>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setUuid(getUuid());
		categoryImpl.setCategoryId(getCategoryId());
		categoryImpl.setCompanyId(getCompanyId());
		categoryImpl.setUserId(getUserId());
		categoryImpl.setUserName(getUserName());
		categoryImpl.setCreateDate(getCreateDate());
		categoryImpl.setModifiedDate(getModifiedDate());
		categoryImpl.setCategoryName(getCategoryName());

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	@Override
	public Category cloneWithOriginalValues() {
		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		categoryImpl.setCategoryId(
			this.<Long>getColumnOriginalValue("categoryId"));
		categoryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		categoryImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		categoryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		categoryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		categoryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		categoryImpl.setCategoryName(
			this.<String>getColumnOriginalValue("categoryName"));

		return categoryImpl;
	}

	@Override
	public int compareTo(Category category) {
		int value = 0;

		if (getCategoryId() < category.getCategoryId()) {
			value = -1;
		}
		else if (getCategoryId() > category.getCategoryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Category)) {
			return false;
		}

		Category category = (Category)object;

		long primaryKey = category.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Category> toCacheModel() {
		CategoryCacheModel categoryCacheModel = new CategoryCacheModel();

		categoryCacheModel.uuid = getUuid();

		String uuid = categoryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			categoryCacheModel.uuid = null;
		}

		categoryCacheModel.categoryId = getCategoryId();

		categoryCacheModel.companyId = getCompanyId();

		categoryCacheModel.userId = getUserId();

		categoryCacheModel.userName = getUserName();

		String userName = categoryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			categoryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			categoryCacheModel.createDate = createDate.getTime();
		}
		else {
			categoryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			categoryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			categoryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		categoryCacheModel.categoryName = getCategoryName();

		String categoryName = categoryCacheModel.categoryName;

		if ((categoryName != null) && (categoryName.length() == 0)) {
			categoryCacheModel.categoryName = null;
		}

		return categoryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Category, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Category, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Category, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Category)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Category>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Category.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _categoryId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _categoryName;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Category, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Category)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("categoryId", _categoryId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("categoryName", _categoryName);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("categoryId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("categoryName", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Category _escapedModel;

}