package org.zilluss.gradle.jade.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.zilluss.gradle.jade.generator.ConfiguredGenerator
import org.zilluss.gradle.jade.generator.HtmlFromJade

class GenerateHtml extends DefaultTask {

    public static final String TASK_NAME = "generateHtml"

    @Input
    def pretty = project.jade.pretty
    @InputFiles
    def templates = project.jade.templates
    @OutputDirectory
    def output = project.jade.output

    @TaskAction
    def generateHtml() {
        def generator = new ConfiguredGenerator(pretty: getPretty())
        new HtmlFromJade(generator).generate(getTemplates()).into(getOutput())
    }
}
