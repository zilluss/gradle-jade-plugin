package org.zilluss.gradle.jade.generator

import org.gradle.api.file.FileCollection
import org.gradle.api.file.FileTree

import spock.lang.Specification

class HtmlFromJadeTest extends Specification {
    def "when a FileTree is passed the output directory structure mirrors the fileTree"(){
        given:
        FileTree fileTreeDummy = Mock(FileTree)
        OutputWriter mirroringWriter = new HtmlFromJade(new ConfiguredGenerator()).generate(fileTreeDummy)
        expect:
        mirroringWriter instanceof MirrorDirectoryStructure
    }

    def "when a FileSet is passed the output directory structure must be flat"(){
        given:
        Set<File> fileSetDummy = new HashSet<File>()
        OutputWriter flatWriter = new HtmlFromJade(new ConfiguredGenerator()).generate(fileSetDummy)
        expect:
        flatWriter instanceof FlatDirectory
    }

    def "when a FileCollection is passed the output directory structure must be flat"(){
        given:
        FileCollection fileCollectionDummy = Mock(FileCollection)
        OutputWriter flatWriter = new HtmlFromJade(new ConfiguredGenerator()).generate(fileCollectionDummy)
        expect:
        flatWriter instanceof FlatDirectory
    }
}
