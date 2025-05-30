#!/bin/sh

rm *.class
javacc ParserL1.jj
javac *.java
