# Logging in GoLang

The log package of go can be used to write logs depending on the requirement of the application. By default the package writes logs to the console but this can be modified as shown below:

## Writing logs to a file

```golang
package main

import (
	"log"
	"os"
)

func main(){
	logger("Writing some logs to a log file")
}

func logger(message string){
	f, err := os.OpenFile(":test.log", os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		log.Println(err)
	}
	defer f.Close()
	logger := log.New(f, "[INFO]:", log.LstdFlags)
	logger.Println(message)
}
```

## Writing logs to stdout

```golang
package main

import (
	"log"
	"os"
)

func main(){
	logger("Writing some logs to stdout")
}

func logger(message string){
	logger := log.New(os.Stdout, "[INFO]:", log.LstdFlags)
	logger.Println(message)
}
```

## Writing logs to Stderr

```golang
package main

import (
	"log"
	"os"
)

func main(){
	logger("Writing some logs to stderr")
}

func logger(message string){
	logger := log.New(os.Stderr, "[INFO]:", log.LstdFlags)
	logger.Println(message)
}
```