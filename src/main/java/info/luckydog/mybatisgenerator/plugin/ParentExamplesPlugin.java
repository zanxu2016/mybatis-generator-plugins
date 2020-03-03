package info.luckydog.mybatisgenerator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class ParentExamplesPlugin extends PluginAdapter {
    private String parentExample;

    public ParentExamplesPlugin() {
    }

    public boolean validate(List<String> warnings) {
        this.parentExample = this.properties.getProperty("parentExample");
        return true;
    }

    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.setSuperClass(this.parentExample);
        topLevelClass.addImportedType(this.parentExample);
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }
}
