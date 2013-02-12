package org.zilluss.gradle.jade.generator

import org.gradle.api.file.FileCollection;
import org.gradle.api.file.FileTree

class HtmlFromJade {
    def generator
    public HtmlFromJade(ConfiguredGenerator generator) {
        this.generator = generator
    }

    public OutputWriter generate(FileTree fileTree){
        return new MirrorDirectoryStructure(generator: generator, fileTree: fileTree)
    }

    public OutputWriter generate(Set<File> fileSet){
        return new FlatDirectory(generator: generator, fileSet: fileSet)
    }
    
    public OutputWriter generate(FileCollection fileCollection){
        return new FlatDirectory(generator: generator, fileSet: fileCollection.files)
    }
}
