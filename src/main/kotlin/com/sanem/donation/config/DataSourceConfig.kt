package com.sanem.donation.config

import com.zaxxer.hikari.HikariDataSource
import jakarta.persistence.EntityManagerFactory
import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EnableJpaRepositories(
    basePackages = ["com.sanem.donation.domain"],
    entityManagerFactoryRef = "mainEntityManagerFactory",
    transactionManagerRef = "mainTransactionManager"
)
class DataSourceConfig {
    @Bean("mainDataSourceProperties")
    @ConfigurationProperties("spring.datasource.main")
    fun dataSourceProperties(): DataSourceProperties = DataSourceProperties()

    @Bean("mainDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.main.hikari")
    fun dataSource(): DataSource =
        dataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource::class.java).build()

    @Bean("mainEntityManagerFactory")
    fun mainEntityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        jpaProperties: JpaProperties
    ): LocalContainerEntityManagerFactoryBean? {
        val dialect = "org.hibernate.dialect.MySQL8Dialect"
        jpaProperties.databasePlatform = dialect
        jpaProperties.properties["hibernate.dialect"] = dialect
        return builder
            .dataSource(dataSource())
            .persistenceUnit("mainPU")
            .packages(
                "com.sanem.donation.domain"
            )
            .properties(jpaProperties.properties)
            .build()
    }

    @Bean("mainTransactionManager")
    fun mainTransactionManager(
        @Qualifier("mainEntityManagerFactory")
        factory: EntityManagerFactory
    ): PlatformTransactionManager? = JpaTransactionManager(factory)
}
