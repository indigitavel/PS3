rm -rf bin/psproject2
javac -d bin src/psproject2/*.java
cd bin
java -cp ./ psproject2.PSProject2
cd ..
rm -rf bin/psproject2