package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RealizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RealizeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRealizeIdIsNull() {
            addCriterion("realize_id is null");
            return (Criteria) this;
        }

        public Criteria andRealizeIdIsNotNull() {
            addCriterion("realize_id is not null");
            return (Criteria) this;
        }

        public Criteria andRealizeIdEqualTo(Integer value) {
            addCriterion("realize_id =", value, "realizeId");
            return (Criteria) this;
        }

        public Criteria andRealizeIdNotEqualTo(Integer value) {
            addCriterion("realize_id <>", value, "realizeId");
            return (Criteria) this;
        }

        public Criteria andRealizeIdGreaterThan(Integer value) {
            addCriterion("realize_id >", value, "realizeId");
            return (Criteria) this;
        }

        public Criteria andRealizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("realize_id >=", value, "realizeId");
            return (Criteria) this;
        }

        public Criteria andRealizeIdLessThan(Integer value) {
            addCriterion("realize_id <", value, "realizeId");
            return (Criteria) this;
        }

        public Criteria andRealizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("realize_id <=", value, "realizeId");
            return (Criteria) this;
        }

        public Criteria andRealizeIdIn(List<Integer> values) {
            addCriterion("realize_id in", values, "realizeId");
            return (Criteria) this;
        }

        public Criteria andRealizeIdNotIn(List<Integer> values) {
            addCriterion("realize_id not in", values, "realizeId");
            return (Criteria) this;
        }

        public Criteria andRealizeIdBetween(Integer value1, Integer value2) {
            addCriterion("realize_id between", value1, value2, "realizeId");
            return (Criteria) this;
        }

        public Criteria andRealizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("realize_id not between", value1, value2, "realizeId");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNameIsNull() {
            addCriterion("sign_name is null");
            return (Criteria) this;
        }

        public Criteria andSignNameIsNotNull() {
            addCriterion("sign_name is not null");
            return (Criteria) this;
        }

        public Criteria andSignNameEqualTo(String value) {
            addCriterion("sign_name =", value, "signName");
            return (Criteria) this;
        }

        public Criteria andSignNameNotEqualTo(String value) {
            addCriterion("sign_name <>", value, "signName");
            return (Criteria) this;
        }

        public Criteria andSignNameGreaterThan(String value) {
            addCriterion("sign_name >", value, "signName");
            return (Criteria) this;
        }

        public Criteria andSignNameGreaterThanOrEqualTo(String value) {
            addCriterion("sign_name >=", value, "signName");
            return (Criteria) this;
        }

        public Criteria andSignNameLessThan(String value) {
            addCriterion("sign_name <", value, "signName");
            return (Criteria) this;
        }

        public Criteria andSignNameLessThanOrEqualTo(String value) {
            addCriterion("sign_name <=", value, "signName");
            return (Criteria) this;
        }

        public Criteria andSignNameLike(String value) {
            addCriterion("sign_name like", value, "signName");
            return (Criteria) this;
        }

        public Criteria andSignNameNotLike(String value) {
            addCriterion("sign_name not like", value, "signName");
            return (Criteria) this;
        }

        public Criteria andSignNameIn(List<String> values) {
            addCriterion("sign_name in", values, "signName");
            return (Criteria) this;
        }

        public Criteria andSignNameNotIn(List<String> values) {
            addCriterion("sign_name not in", values, "signName");
            return (Criteria) this;
        }

        public Criteria andSignNameBetween(String value1, String value2) {
            addCriterion("sign_name between", value1, value2, "signName");
            return (Criteria) this;
        }

        public Criteria andSignNameNotBetween(String value1, String value2) {
            addCriterion("sign_name not between", value1, value2, "signName");
            return (Criteria) this;
        }

        public Criteria andIndexIsNull() {
            addCriterion("index is null");
            return (Criteria) this;
        }

        public Criteria andIndexIsNotNull() {
            addCriterion("index is not null");
            return (Criteria) this;
        }

        public Criteria andIndexEqualTo(Integer value) {
            addCriterion("index =", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotEqualTo(Integer value) {
            addCriterion("index <>", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThan(Integer value) {
            addCriterion("index >", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("index >=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThan(Integer value) {
            addCriterion("index <", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThanOrEqualTo(Integer value) {
            addCriterion("index <=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexIn(List<Integer> values) {
            addCriterion("index in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotIn(List<Integer> values) {
            addCriterion("index not in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexBetween(Integer value1, Integer value2) {
            addCriterion("index between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("index not between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNameIsNull() {
            addCriterion("index_name is null");
            return (Criteria) this;
        }

        public Criteria andIndexNameIsNotNull() {
            addCriterion("index_name is not null");
            return (Criteria) this;
        }

        public Criteria andIndexNameEqualTo(String value) {
            addCriterion("index_name =", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotEqualTo(String value) {
            addCriterion("index_name <>", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameGreaterThan(String value) {
            addCriterion("index_name >", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameGreaterThanOrEqualTo(String value) {
            addCriterion("index_name >=", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLessThan(String value) {
            addCriterion("index_name <", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLessThanOrEqualTo(String value) {
            addCriterion("index_name <=", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLike(String value) {
            addCriterion("index_name like", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotLike(String value) {
            addCriterion("index_name not like", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameIn(List<String> values) {
            addCriterion("index_name in", values, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotIn(List<String> values) {
            addCriterion("index_name not in", values, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameBetween(String value1, String value2) {
            addCriterion("index_name between", value1, value2, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotBetween(String value1, String value2) {
            addCriterion("index_name not between", value1, value2, "indexName");
            return (Criteria) this;
        }

        public Criteria andSqlIsNull() {
            addCriterion("sql is null");
            return (Criteria) this;
        }

        public Criteria andSqlIsNotNull() {
            addCriterion("sql is not null");
            return (Criteria) this;
        }

        public Criteria andSqlEqualTo(String value) {
            addCriterion("sql =", value, "sql");
            return (Criteria) this;
        }

        public Criteria andSqlNotEqualTo(String value) {
            addCriterion("sql <>", value, "sql");
            return (Criteria) this;
        }

        public Criteria andSqlGreaterThan(String value) {
            addCriterion("sql >", value, "sql");
            return (Criteria) this;
        }

        public Criteria andSqlGreaterThanOrEqualTo(String value) {
            addCriterion("sql >=", value, "sql");
            return (Criteria) this;
        }

        public Criteria andSqlLessThan(String value) {
            addCriterion("sql <", value, "sql");
            return (Criteria) this;
        }

        public Criteria andSqlLessThanOrEqualTo(String value) {
            addCriterion("sql <=", value, "sql");
            return (Criteria) this;
        }

        public Criteria andSqlLike(String value) {
            addCriterion("sql like", value, "sql");
            return (Criteria) this;
        }

        public Criteria andSqlNotLike(String value) {
            addCriterion("sql not like", value, "sql");
            return (Criteria) this;
        }

        public Criteria andSqlIn(List<String> values) {
            addCriterion("sql in", values, "sql");
            return (Criteria) this;
        }

        public Criteria andSqlNotIn(List<String> values) {
            addCriterion("sql not in", values, "sql");
            return (Criteria) this;
        }

        public Criteria andSqlBetween(String value1, String value2) {
            addCriterion("sql between", value1, value2, "sql");
            return (Criteria) this;
        }

        public Criteria andSqlNotBetween(String value1, String value2) {
            addCriterion("sql not between", value1, value2, "sql");
            return (Criteria) this;
        }

        public Criteria andInfoIsNull() {
            addCriterion("info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(String value) {
            addCriterion("info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(String value) {
            addCriterion("info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(String value) {
            addCriterion("info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(String value) {
            addCriterion("info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(String value) {
            addCriterion("info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(String value) {
            addCriterion("info <=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLike(String value) {
            addCriterion("info like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotLike(String value) {
            addCriterion("info not like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoIn(List<String> values) {
            addCriterion("info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotIn(List<String> values) {
            addCriterion("info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(String value1, String value2) {
            addCriterion("info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(String value1, String value2) {
            addCriterion("info not between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdIsNull() {
            addCriterion("interface_id is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdIsNotNull() {
            addCriterion("interface_id is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdEqualTo(Integer value) {
            addCriterion("interface_id =", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotEqualTo(Integer value) {
            addCriterion("interface_id <>", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdGreaterThan(Integer value) {
            addCriterion("interface_id >", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("interface_id >=", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdLessThan(Integer value) {
            addCriterion("interface_id <", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdLessThanOrEqualTo(Integer value) {
            addCriterion("interface_id <=", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdIn(List<Integer> values) {
            addCriterion("interface_id in", values, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotIn(List<Integer> values) {
            addCriterion("interface_id not in", values, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdBetween(Integer value1, Integer value2) {
            addCriterion("interface_id between", value1, value2, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("interface_id not between", value1, value2, "interfaceId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}