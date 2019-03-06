<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org/DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.mage.mapper.OperationDao">

<resultMap id="operationPro" type="operation">
<id property="id" column="id"></id>
<result property="name" column="name"></result>
<result property="time" column="time"></result>
<result property="type" column="type"></result>
</resultMap>



<resultMap id="userinfoPro" type="userInfo">
<id property="username" column="username"></id>

<result property="name" column="name"></result>
<result property="email" column="email"></result>
<result property="createTime" column="createTime"></result>
<result property="userType" column="userType"></result>


<collection property="operations" resultMap="operationPro"  ofType="operation"></collection>

</resultMap>

<select id="selectOperationsByUsername" resultMap="userinfoPro" parameterType="string">
        select u.*,o.* from userinfo u left join operation o
        on u.username = o.username where u.username = #{username};
</select>
</mapper>