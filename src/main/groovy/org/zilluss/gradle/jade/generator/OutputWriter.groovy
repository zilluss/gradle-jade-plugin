package org.zilluss.gradle.jade.generator

import java.io.File

interface OutputWriter
{
    public void into(File outputDirectory)
}
