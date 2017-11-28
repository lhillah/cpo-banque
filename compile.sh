#!/bin/bash

cd TD-Banque/
rm -rf bin
mkdir -p bin
cd src/
javac main/Main.java -d ../bin/
