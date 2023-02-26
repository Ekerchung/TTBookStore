package com.shung.mapper;

import com.shung.pojo.OrderItem;
import com.shung.pojo.OrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_item
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int countByExample(OrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_item
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int deleteByExample(OrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_item
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int insert(OrderItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_item
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int insertSelective(OrderItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_item
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    List<OrderItem> selectByExample(OrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_item
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int updateByExampleSelective(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_item
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int updateByExample(@Param("record") OrderItem record, @Param("example") OrderItemExample example);
}