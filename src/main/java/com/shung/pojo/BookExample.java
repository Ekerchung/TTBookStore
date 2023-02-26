package com.shung.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
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

        public Criteria andBIdIsNull() {
            addCriterion("b_id is null");
            return (Criteria) this;
        }

        public Criteria andBIdIsNotNull() {
            addCriterion("b_id is not null");
            return (Criteria) this;
        }

        public Criteria andBIdEqualTo(Integer value) {
            addCriterion("b_id =", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotEqualTo(Integer value) {
            addCriterion("b_id <>", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThan(Integer value) {
            addCriterion("b_id >", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_id >=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThan(Integer value) {
            addCriterion("b_id <", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThanOrEqualTo(Integer value) {
            addCriterion("b_id <=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdIn(List<Integer> values) {
            addCriterion("b_id in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotIn(List<Integer> values) {
            addCriterion("b_id not in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdBetween(Integer value1, Integer value2) {
            addCriterion("b_id between", value1, value2, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotBetween(Integer value1, Integer value2) {
            addCriterion("b_id not between", value1, value2, "bId");
            return (Criteria) this;
        }

        public Criteria andBNameIsNull() {
            addCriterion("b_name is null");
            return (Criteria) this;
        }

        public Criteria andBNameIsNotNull() {
            addCriterion("b_name is not null");
            return (Criteria) this;
        }

        public Criteria andBNameEqualTo(String value) {
            addCriterion("b_name =", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotEqualTo(String value) {
            addCriterion("b_name <>", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameGreaterThan(String value) {
            addCriterion("b_name >", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameGreaterThanOrEqualTo(String value) {
            addCriterion("b_name >=", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLessThan(String value) {
            addCriterion("b_name <", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLessThanOrEqualTo(String value) {
            addCriterion("b_name <=", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLike(String value) {
            addCriterion("b_name like", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotLike(String value) {
            addCriterion("b_name not like", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameIn(List<String> values) {
            addCriterion("b_name in", values, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotIn(List<String> values) {
            addCriterion("b_name not in", values, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameBetween(String value1, String value2) {
            addCriterion("b_name between", value1, value2, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotBetween(String value1, String value2) {
            addCriterion("b_name not between", value1, value2, "bName");
            return (Criteria) this;
        }

        public Criteria andBAuthorIsNull() {
            addCriterion("b_author is null");
            return (Criteria) this;
        }

        public Criteria andBAuthorIsNotNull() {
            addCriterion("b_author is not null");
            return (Criteria) this;
        }

        public Criteria andBAuthorEqualTo(String value) {
            addCriterion("b_author =", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotEqualTo(String value) {
            addCriterion("b_author <>", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorGreaterThan(String value) {
            addCriterion("b_author >", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("b_author >=", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLessThan(String value) {
            addCriterion("b_author <", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLessThanOrEqualTo(String value) {
            addCriterion("b_author <=", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLike(String value) {
            addCriterion("b_author like", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotLike(String value) {
            addCriterion("b_author not like", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorIn(List<String> values) {
            addCriterion("b_author in", values, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotIn(List<String> values) {
            addCriterion("b_author not in", values, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorBetween(String value1, String value2) {
            addCriterion("b_author between", value1, value2, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotBetween(String value1, String value2) {
            addCriterion("b_author not between", value1, value2, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBPriceIsNull() {
            addCriterion("b_price is null");
            return (Criteria) this;
        }

        public Criteria andBPriceIsNotNull() {
            addCriterion("b_price is not null");
            return (Criteria) this;
        }

        public Criteria andBPriceEqualTo(BigDecimal value) {
            addCriterion("b_price =", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotEqualTo(BigDecimal value) {
            addCriterion("b_price <>", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceGreaterThan(BigDecimal value) {
            addCriterion("b_price >", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b_price >=", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceLessThan(BigDecimal value) {
            addCriterion("b_price <", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("b_price <=", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceIn(List<BigDecimal> values) {
            addCriterion("b_price in", values, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotIn(List<BigDecimal> values) {
            addCriterion("b_price not in", values, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b_price between", value1, value2, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b_price not between", value1, value2, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBSalesIsNull() {
            addCriterion("b_sales is null");
            return (Criteria) this;
        }

        public Criteria andBSalesIsNotNull() {
            addCriterion("b_sales is not null");
            return (Criteria) this;
        }

        public Criteria andBSalesEqualTo(Integer value) {
            addCriterion("b_sales =", value, "bSales");
            return (Criteria) this;
        }

        public Criteria andBSalesNotEqualTo(Integer value) {
            addCriterion("b_sales <>", value, "bSales");
            return (Criteria) this;
        }

        public Criteria andBSalesGreaterThan(Integer value) {
            addCriterion("b_sales >", value, "bSales");
            return (Criteria) this;
        }

        public Criteria andBSalesGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_sales >=", value, "bSales");
            return (Criteria) this;
        }

        public Criteria andBSalesLessThan(Integer value) {
            addCriterion("b_sales <", value, "bSales");
            return (Criteria) this;
        }

        public Criteria andBSalesLessThanOrEqualTo(Integer value) {
            addCriterion("b_sales <=", value, "bSales");
            return (Criteria) this;
        }

        public Criteria andBSalesIn(List<Integer> values) {
            addCriterion("b_sales in", values, "bSales");
            return (Criteria) this;
        }

        public Criteria andBSalesNotIn(List<Integer> values) {
            addCriterion("b_sales not in", values, "bSales");
            return (Criteria) this;
        }

        public Criteria andBSalesBetween(Integer value1, Integer value2) {
            addCriterion("b_sales between", value1, value2, "bSales");
            return (Criteria) this;
        }

        public Criteria andBSalesNotBetween(Integer value1, Integer value2) {
            addCriterion("b_sales not between", value1, value2, "bSales");
            return (Criteria) this;
        }

        public Criteria andBStokeIsNull() {
            addCriterion("b_stoke is null");
            return (Criteria) this;
        }

        public Criteria andBStokeIsNotNull() {
            addCriterion("b_stoke is not null");
            return (Criteria) this;
        }

        public Criteria andBStokeEqualTo(Integer value) {
            addCriterion("b_stoke =", value, "bStoke");
            return (Criteria) this;
        }

        public Criteria andBStokeNotEqualTo(Integer value) {
            addCriterion("b_stoke <>", value, "bStoke");
            return (Criteria) this;
        }

        public Criteria andBStokeGreaterThan(Integer value) {
            addCriterion("b_stoke >", value, "bStoke");
            return (Criteria) this;
        }

        public Criteria andBStokeGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_stoke >=", value, "bStoke");
            return (Criteria) this;
        }

        public Criteria andBStokeLessThan(Integer value) {
            addCriterion("b_stoke <", value, "bStoke");
            return (Criteria) this;
        }

        public Criteria andBStokeLessThanOrEqualTo(Integer value) {
            addCriterion("b_stoke <=", value, "bStoke");
            return (Criteria) this;
        }

        public Criteria andBStokeIn(List<Integer> values) {
            addCriterion("b_stoke in", values, "bStoke");
            return (Criteria) this;
        }

        public Criteria andBStokeNotIn(List<Integer> values) {
            addCriterion("b_stoke not in", values, "bStoke");
            return (Criteria) this;
        }

        public Criteria andBStokeBetween(Integer value1, Integer value2) {
            addCriterion("b_stoke between", value1, value2, "bStoke");
            return (Criteria) this;
        }

        public Criteria andBStokeNotBetween(Integer value1, Integer value2) {
            addCriterion("b_stoke not between", value1, value2, "bStoke");
            return (Criteria) this;
        }

        public Criteria andBImgpathIsNull() {
            addCriterion("b_imgPath is null");
            return (Criteria) this;
        }

        public Criteria andBImgpathIsNotNull() {
            addCriterion("b_imgPath is not null");
            return (Criteria) this;
        }

        public Criteria andBImgpathEqualTo(String value) {
            addCriterion("b_imgPath =", value, "bImgpath");
            return (Criteria) this;
        }

        public Criteria andBImgpathNotEqualTo(String value) {
            addCriterion("b_imgPath <>", value, "bImgpath");
            return (Criteria) this;
        }

        public Criteria andBImgpathGreaterThan(String value) {
            addCriterion("b_imgPath >", value, "bImgpath");
            return (Criteria) this;
        }

        public Criteria andBImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("b_imgPath >=", value, "bImgpath");
            return (Criteria) this;
        }

        public Criteria andBImgpathLessThan(String value) {
            addCriterion("b_imgPath <", value, "bImgpath");
            return (Criteria) this;
        }

        public Criteria andBImgpathLessThanOrEqualTo(String value) {
            addCriterion("b_imgPath <=", value, "bImgpath");
            return (Criteria) this;
        }

        public Criteria andBImgpathLike(String value) {
            addCriterion("b_imgPath like", value, "bImgpath");
            return (Criteria) this;
        }

        public Criteria andBImgpathNotLike(String value) {
            addCriterion("b_imgPath not like", value, "bImgpath");
            return (Criteria) this;
        }

        public Criteria andBImgpathIn(List<String> values) {
            addCriterion("b_imgPath in", values, "bImgpath");
            return (Criteria) this;
        }

        public Criteria andBImgpathNotIn(List<String> values) {
            addCriterion("b_imgPath not in", values, "bImgpath");
            return (Criteria) this;
        }

        public Criteria andBImgpathBetween(String value1, String value2) {
            addCriterion("b_imgPath between", value1, value2, "bImgpath");
            return (Criteria) this;
        }

        public Criteria andBImgpathNotBetween(String value1, String value2) {
            addCriterion("b_imgPath not between", value1, value2, "bImgpath");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_book
     *
     * @mbggenerated do_not_delete_during_merge Sat Feb 25 01:45:50 CST 2023
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
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