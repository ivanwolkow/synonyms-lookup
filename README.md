# synonyms lookup application

This app allows you to build a synonym dictionary. 
Afterwards you can quickly determine whether two words are synonyms or not. 

## Build and run

```bash
./gradlew shadowJar
java -jar build/libs/synonyms-lookup-1.0-SNAPSHOT-all.jar test.in test.out
```

## Data format
You can find examples of input files [here](src/test/resources/in/example.in) and [here](src/test/resources/in/example_big.in).