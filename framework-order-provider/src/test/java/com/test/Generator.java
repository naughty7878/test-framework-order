package com.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Generator {

    public static void main(String[] args) {
        String url = "jdbc:mysql://192.168.1.170:3306/test_springcloud?allowPublicKeyRetrieval=true&useSSL=false";
        String username = "root";
        String password = "123456";
        String outputDir = "C:\\Users\\H__D\\Desktop";
        String xmlPath = "C:\\Users\\H__D\\Desktop";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("H__D")                  // 设置作者
//                            .enableSwagger()              // 开启 swagger 模式
                            .outputDir(outputDir);          // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com")                   // 设置父包名
                            .moduleName("test.order.provider")           // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, xmlPath)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_employee")        // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_");  // 设置过滤表前缀

                            .entityBuilder()                // 实体策略配置
//                            .enableColumnConstant()       // 开启生成字段常量    默认值:false， 生成：public static final String LAST_NAME = "last_name";
//                            .enableChainModel()           // 开启链式模型    默认值:false 生成：@Accessors(chain = true)
//                            .enableFileOverride()         // 覆盖已生成文件    默认值:false
                            .enableLombok()                 // 开启 lombok 模型    默认值:false
//                            .enableTableFieldAnnotation()    // 开启生成实体时生成字段注解    默认值:false, 生成：@TableField("last_name")
                            .mapperBuilder()                // mapper 策略配置
                            .superClass(BaseMapper.class)   // 设置父类
                            .enableMapperAnnotation()       // 开启 @Mapper 注解    默认值:false
                            .enableBaseResultMap()          // 启用 BaseResultMap 生成    默认值:false
                            .enableBaseColumnList()         // 启用 BaseColumnList    默认值:false
                    ;

                })

                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}