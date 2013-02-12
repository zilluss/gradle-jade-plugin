package org.zilluss.gradle.jade.generator

import org.gradle.api.file.FileTree
import org.gradle.api.file.FileVisitDetails

class MirrorDirectoryStructure implements OutputWriter {
    FileTree fileTree
    ConfiguredGenerator generator

    @Override
    public void into(File outputDirectoryRoot) {
        fileTree.visit { treeNode ->
            if(!treeNode.isDirectory()) generateHtml(treeNode, outputDirectoryRoot)
        }
    }

    def generateHtml(FileVisitDetails jadeTemplate, File outputDirectoryRoot) {
        def outputDirectory = new File(outputDirectoryRoot, jadeTemplate.relativePath.parent.pathString)
        generator.generateHtml(jadeTemplate.file, outputDirectory)
    }
}
