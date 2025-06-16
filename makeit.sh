#!/bin/sh

rm *.class
javacc ParserX++.jj
javac *.java
