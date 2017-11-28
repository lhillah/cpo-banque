#!/bin/bash

cd TD-Banque/src
rm -rf bin
mkdir -p bin
javac main/Main.java -d ../bin/
