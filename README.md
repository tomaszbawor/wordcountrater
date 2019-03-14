## WordCountRater

Program rating text files in directory by searched phrases

### Instructions

#### Building
- In order to build application JAVA8 or newer is needed. 
- Maven is not necessary as there is maven wrapper provided

You could build it using command: 
```bash
./mvn2 clean package
```
this will create executable jar file in your `/target` directory.

# Running

In order to run application you may execute:

 ```
 java -jar target/wordcountrater-1.0-SNAPSHOT.jar /Users/name/textfiles
 ```
 
 where `target/wordcountrater-1.0-SNAPSHOT.jar` is a path to executable jar and
 `/Users/name/textfiles` is an absolute path to your folder containing text files.
 
 Afterwards `search> ` prompt will inform you that you can enter words that you will be searching. 
 
 In order to exit application just type `:quit`
  