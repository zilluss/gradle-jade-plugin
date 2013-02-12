package org.zilluss.gradle.jade.generator


class FlatDirectory implements OutputWriter{
    Set<File> fileSet
    ConfiguredGenerator generator

    @Override
    public void into(File outputDirectory) {
        fileSet.each { file ->
            generator.generateHtml(file, outputDirectory)
        }
    }
}
