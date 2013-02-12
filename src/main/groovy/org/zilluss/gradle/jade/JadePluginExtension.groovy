package org.zilluss.gradle.jade

import org.gradle.api.Project

class JadePluginExtension {

    public static final String EXTENSION_NAME = "jade"

    public JadePluginExtension(Project project){
        templates = project.fileTree("templates/jade").include("**/*.jade")
        output = "build/html" as File
        pretty = false
        model = new Properties()
    }

    def pretty
    def templates
    def model
    def output
}
