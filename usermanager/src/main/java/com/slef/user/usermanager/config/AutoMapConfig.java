package com.slef.user.usermanager.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import java.util.Properties;

/**
 * Created by hao on 2017/12/12.
 */
@Configuration
public class AutoMapConfig {
    @Autowired
    private HikariDataSource hikariDataSource;

    @Bean(name = "DefaultSqlSessionFactory")
    @DependsOn("HikariDataSource")
    public SqlSessionFactory sessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        VFS.addImplClass(SpringBootVFS.class);
        Properties properties = new Properties();
        properties.setProperty("cacheEnabled", "false");
        properties.setProperty("lazyLoadingEnabled", "false");
        properties.setProperty("multipleResultSetsEnabled", "true");
        properties.setProperty("useColumnLabel", "true");
        properties.setProperty("useGeneratedKeys", "false");
        properties.setProperty("defaultExecutorType", "SIMPLE");
        properties.setProperty("defaultStatementTimeout", "25000");
        bean.setConfigurationProperties(properties);
        Properties multiProperties = new Properties();
        multiProperties.setProperty("commonDatabase", "common");
        multiProperties.setProperty("commonTables", "");
        Properties pageProperties = new Properties();
        bean.setTypeAliasesPackage("com.slef");
        pageProperties.setProperty("dialectClass", "com.mshz.service.base.datasource.mybatis.dialect.MySqlDialect");


        bean.setDataSource(hikariDataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath*:mybatis/mysql/**/*.xml"));
        return bean.getObject();
    }

}
