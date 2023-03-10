package com.shung.mapper;

import com.shung.pojo.Book;
import com.shung.pojo.BookExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int countByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int deleteByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int deleteByPrimaryKey(Integer bId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int insert(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int insertSelective(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    List<Book> selectByExample(BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    Book selectByPrimaryKey(Integer bId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int updateByPrimaryKeySelective(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_book
     *
     * @mbggenerated Sat Feb 25 01:45:50 CST 2023
     */
    int updateByPrimaryKey(Book record);
}