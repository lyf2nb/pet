package pet.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorSqlmap {

	/**
	 * 数据库配置信息
	 */
	private static final String PET = "pet";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://101.200.53.20:3306/pet";
	private static final String USERNAME = "xiaogouzi";
	private static final String PASSWORD = "xiaogouzi";

	/**
	 * 文件生成路径
	 */
	private static final String MODEL_TARGET_PACKAGE = "pet.model";
	private static final String MODEL_TARGET_PROJECT = "src/main/java";

	private static final String MAPPER_TARGET_PACKAGE = "Mybatis_Mapper";
	private static final String MAPPER_TARGET_PROJECT = "src/main/resources";

	private static final String DAO_TARGET_PACKAGE = "pet.dao";
	private static final String DAO_TARGET_PROJECT = "src/main/java";

	/**
	 * 需要生成的目标表
	 */
	private static final String SCHEMA= "pet";
	private static final String TABLE_NAME = "tb_generator_datasource";
	private static final String DOMAIN_OBJECT_NAME = "TableRole";
	private static final String MODULE = ".employee";


	public void generator() throws Exception{

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//指定 逆向工程配置文件
		File configFile = new File("generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		// 获取xml中配置的上下文信息
		Context context = config.getContext(PET);
		// 设置上下文--设置jdbc连接信息
		JDBCConnectionConfiguration jdbcConfig = context.getJdbcConnectionConfiguration();
		jdbcConfig.setDriverClass(DRIVER);
		jdbcConfig.setConnectionURL(URL);
		jdbcConfig.setUserId(USERNAME);
		jdbcConfig.setPassword(PASSWORD);
		context.setJdbcConnectionConfiguration(jdbcConfig);
		// 设置上下文--设置表信息 目前只设置一个table
		List<TableConfiguration> list = context.getTableConfigurations();
		TableConfiguration tableConfig = list.get(0);
		//TableConfiguration tableConfig = new TableConfiguration(context);
		tableConfig.setSchema(SCHEMA);
		tableConfig.setTableName(TABLE_NAME);
		tableConfig.setDomainObjectName(DOMAIN_OBJECT_NAME);
		tableConfig.setCountByExampleStatementEnabled(false);
		tableConfig.setUpdateByExampleStatementEnabled(false);
		tableConfig.setDeleteByExampleStatementEnabled(false);
		tableConfig.setSelectByExampleStatementEnabled(false);
		tableConfig.setSelectByExampleStatementEnabled(false);
		//context.addTableConfiguration(tableConfig);


		// 设置上下文--设置javaModelGenerator路径
		JavaModelGeneratorConfiguration modelConfig = context.getJavaModelGeneratorConfiguration();
		modelConfig.setTargetPackage(StringUtils.isEmpty(MODULE)?MODEL_TARGET_PACKAGE:MODEL_TARGET_PACKAGE+MODULE);
		modelConfig.setTargetProject(MODEL_TARGET_PROJECT);
		// 设置上下文--设置sqlMapGenerator路径
		SqlMapGeneratorConfiguration sqlMapConfig = context.getSqlMapGeneratorConfiguration();
		sqlMapConfig.setTargetPackage(StringUtils.isEmpty(MODULE)?MAPPER_TARGET_PACKAGE:MAPPER_TARGET_PACKAGE+MODULE);
		sqlMapConfig.setTargetProject(MAPPER_TARGET_PROJECT);
		// 设置上下文--设置javaClientGenerator路径
		JavaClientGeneratorConfiguration daoConfig = context.getJavaClientGeneratorConfiguration();
		daoConfig.setTargetPackage(StringUtils.isEmpty(MODULE)?DAO_TARGET_PACKAGE:DAO_TARGET_PACKAGE+MODULE);
		daoConfig.setTargetProject(DAO_TARGET_PROJECT);

		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);

	} 
	public static void main(String[] args) throws Exception {

		try {
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void p(Object o){
		System.out.println(o);
	}

}
