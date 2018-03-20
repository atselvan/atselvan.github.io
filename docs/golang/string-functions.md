# String Functions in Go

## Title

Capitalize a string

```go
package main

import (
	"fmt"
	"strings"
)

func main() {
	string := "my name is allan"
	fmt.Println("Title : ", strings.Title(string))
}
// Output:
//Title :  My Name Is Allan
```

## ToLower

Convert a string to lower case

```go
package main

import (
	"fmt"
	"strings"
)

func main() {
	string := "MY Name IS AllAn"
	fmt.Println("ToLower : ", strings.ToLower(string))
}
//Output:
//ToLower :  my name is allan
```

## ToUpper

Conver a string to upper case

```go
package main

import (
	"fmt"
	"strings"
)

func main() {
	string := "MY Name IS AllAn"
fmt.Println("ToUpper : ", strings.ToUpper(string))
}
//Output:
//ToUpper :  MY NAME IS ALLAN
```

## Contains

Checks if a string contains a substring

```go
package main

import (
	"fmt"
	"strings"
)

func main() {
	string := "My name is Allan"
	fmt.Println("Contains : ", strings.Contains(string, "Allan"))
	fmt.Println("Contains : ", strings.Contains(string, "something"))
}
//Output:
//Contains :  true
//Contains :  false
```

## Replace

Replace a substring with another

```go
package main

import (
	"fmt"
	"strings"
)

func main() {
	string := "My name is Allan"
	fmt.Println("Replace : ", strings.Replace(string, "Allan", "Allan Selvan", 1))
}
//Output:
//Replace :  My name is Allan Selvan
```

## Split

Split a string

```go
package main

import (
	"fmt"
	"strings"
)

func main() {
	string := "stone,paper,scissor"
	fmt.Println("Split : ", strings.Split(string, ","))
}
//Output:
//Split :  [stone paper scissor]
```

## Join

```go
package main

import (
	"fmt"
	"strings"
)

func main() {
	string := []string{"stone", "paper", "scissor"}
	fmt.Println("Join : ", strings.Join(string, ","))
}
//Output:
//Join :  stone,paper,scissor
```