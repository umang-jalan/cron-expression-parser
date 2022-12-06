# cron-expression-parser
Cron expression parser is a command line application which parses a cron string and expands each field to show the times at which it will run. 

_Supported Features_
* Valid expression must have 5 parts followed by a command
* An expression can contain following symbols
    * Hyphens (-) : Allows a range of values , e.g., `1-12`
    * Comma (,) :  Allows multiple values or multiple sub expressions , e.g., `1,2,3,4` , `*/12,2-15,5`
    * Slash (/) : Allows intervals of values, e.g., `*/15` will  return values in intervals of 15
    * Any Value (*) : Allows any value within defined boundary, e.g., if boundary is [1,30], then this will return all values between [1,30]
    
* Each time part has a fixed range which the given expression must satisfy
    * Minute : 0-59
    * Hour : 0-23
    * Day of month : 1-31
    * Month : 1-12
    * Day of Week : 0-6
    
_Unsupported features_
* special time strings, like @yearly, @monthly etc
* words notation for month/day of week
* question mark
* Slash expression starting with non-asterisk(*) value, e.g, `1/15` is not supported
* Separate number of days in each month. e.g, February is not handled as 28-29 days month 
* Year is not supported 



## Installation
*  Clone the project 

`git clone https://github.com/umang-jalan/cron-expression-parser.git`

* Change the directory 

`cd cron-expression-parser`

* Set up gradle

`./gradlew install && ./gradlew build`

## Usage

- Run via java jar using command line
``` 
java -jar cron-expression-parser-1.0.0.jar "[CRON_EXPRESSION] [COMMAND]"
```
_Sample Command_ :
```
java -jar cron-expression-parser-1.0.0.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
```

- Alternatively, `./gradlew` can also be used to run the application
```
./gradlew run --args='"[CRON_EXPRESSION] [COMMAND]"'
```
_Sample Command_ :
```
e.g., /gradlew run --args='"*/15 0 1,15 * 1-5 /usr/bin/find"'
```

In both approaches, the input arguments has two parts:
- `CRON_EXPRESSION`, which is a cron string like `"*/15 0 1,15 * 1-5"` 
- `COMMAND` which is the command to run

## Output

- **Success** - Valid Expression `"*/15 0 1-15 * 1-5 /usr/bin/find"`
```
minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
```

* **Error** : Invalid Expression : `"*/15 0 1-15 * 1-8 /usr/bin/find"`

```
[ERROR] [DAY_OF_WEEK] invalid start and end values, Allowed Range : min = 0 max = 6
```
