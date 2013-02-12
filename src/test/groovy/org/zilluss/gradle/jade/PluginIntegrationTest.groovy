

package org.zilluss.gradle.jade

import org.gradle.GradleLauncher
import org.gradle.StartParameter
import org.gradle.testfixtures.ProjectBuilder
import org.zilluss.gradle.jade.tasks.GenerateHtml

import spock.lang.Specification

class PluginIntegrationTest extends Specification {

    def "can successfully launch build script with plugin and define custom tasks" (){
        given:
        def buildDotGradle = new File(this.getClass().getResource("build.gradle").toURI())
        def startParameter = new StartParameter(buildFile: buildDotGradle)
        def launcher = GradleLauncher.newInstance(startParameter)
        def result = launcher.run()
        new org.zilluss.gradle.jade.JadePlugin()

        expect:
        result.failure == null
    }

    def "plugin tasks exist"(){
        given:
        def project = ProjectBuilder.builder().build()
        new JadePlugin().apply(project)

        expect:
        project.tasks["generateHtml"] instanceof GenerateHtml
    }

    def "plugin extensions exist"(){
        given:
        def project = ProjectBuilder.builder().build()
        new JadePlugin().apply(project)

        expect:
        project.jade instanceof JadePluginExtension
    }
}
