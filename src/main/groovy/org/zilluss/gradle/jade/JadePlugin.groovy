package org.zilluss.gradle.jade

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.zilluss.gradle.jade.tasks.GenerateHtml


class JadePlugin implements Plugin<Project>{
    void apply(final Project project){
        project.apply(plugin: "base")
        project.extensions.create(JadePluginExtension.EXTENSION_NAME, JadePluginExtension, project)
        applyTasks(project)
    }

    void applyTasks(final Project project){
        project.task(GenerateHtml.TASK_NAME, type: GenerateHtml, group: 'Build', description: 'Generate html files from jade templates') {
            pretty = project.jade.pretty
            output =  project.jade.output
            templates =  project.jade.templates
        }
    }
}
