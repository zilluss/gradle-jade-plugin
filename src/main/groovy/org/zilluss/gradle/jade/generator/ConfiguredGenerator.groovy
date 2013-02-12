package org.zilluss.gradle.jade.generator

import de.neuland.jade4j.Jade4J

class ConfiguredGenerator implements Generator{
    def pretty
    def defaultModel = null

    @Override
    public void generateHtml(File inputFile, File outputDirectory){
        outputDirectory.mkdirs()
        def outputFile = outputFileFrom(inputFile, outputDirectory)
        new PrintWriter(outputFile.path).withWriter{ fileWriter ->
            Jade4J.render(inputFile.absolutePath, defaultModel, fileWriter, pretty)
        }
    }

    def outputFileFrom(File inputFile, outputDirectory){
        def indexOfExtension = inputFile.name.lastIndexOf(".jade")
        def filenameWithoutExtension = inputFile.name.substring(0, indexOfExtension)
        new File(outputDirectory, filenameWithoutExtension + ".html")
    }
}
