package com.common.adapter;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author author
 * @date 2020/7/30 16:52
 */
public class MyLombokPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // 到入需要注解的包
        topLevelClass.addImportedType("lombok.Data");
        // topLevelClass.addImportedType("lombok.Builder");
        //  topLevelClass.addImportedType("lombok.NoArgsConstructor");
        // topLevelClass.addImportedType("lombok.AllArgsConstructor");

        // 添加domain的注解
        topLevelClass.addAnnotation("@Data");
        // topLevelClass.addAnnotation("@Builder");
        // topLevelClass.addAnnotation("@NoArgsConstructor");
        //   topLevelClass.addAnnotation("@AllArgsConstructor");

        // 添加domain的注释
        topLevelClass.addJavaDocLine("/**");
        //   topLevelClass.addJavaDocLine("* @ClassName: " + topLevelClass.getType().getShortName());
        //  topLevelClass.addJavaDocLine("* @Description: ");
        topLevelClass.addJavaDocLine("* @author: Mybatis Generator");
        topLevelClass.addJavaDocLine("* @date " + date2Str(new Date()));
        topLevelClass.addJavaDocLine("*/");
        return true;
    }

    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
                                   IntrospectedTable introspectedTable) {
        // Mapper文件的注释
        interfaze.addJavaDocLine("/**");
        //   interfaze.addJavaDocLine("* @ClassName: " + interfaze.getType().getShortName());
        //   interfaze.addJavaDocLine("* @Description: ");
        interfaze.addJavaDocLine("* @author: Mybatis Generator");
        interfaze.addJavaDocLine("* @date " + date2Str(new Date()));
        interfaze.addJavaDocLine("*/");
        return true;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 不生成getter
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 不生成setter
        return false;
    }

    /**
     * 格式化时间字符串
     *
     * @param date
     * @return
     * @author: renkai721
     * @date: 2018年7月13日 上午11:17:52
     * @Title: date2Str
     * @Description:
     */
    private String date2Str(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}
