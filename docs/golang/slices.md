# Slices in Go

## Declaring a slice

```go
package main

import "fmt"

func main() {
	letters := []string{"a", "b", "c", "d"}
	fmt.Println(letters)
}
//Output: 
//[a b c d]
```

## Adding a entry to a slice

```go
package main

import "fmt"

func main() {
	letters := []string{"a", "b", "c", "d"}
	letters = append(letters, "e")
	fmt.Println(letters)
}
//Output: 
//[a b c d e]
```

## Get the length of a slice

```go
package main

import "fmt"

func main() {
	letters := []string{"a", "b", "c", "d"}
	fmt.Println(letters)
	fmt.Println("Length of the slice is : ", len(letters))
}
//Output:
//[a b c d]
//Length of the slice is :  4
```

## Check if a entry exists in a slice

```go
package main

import "fmt"

func main() {
	letters := []string{"a", "b", "c", "d"}
	fmt.Println(entryExists(letters, "a"))
	fmt.Println(entryExists(letters, "e"))
}

func entryExists(slice []string, entry string) bool{
	for i:=0; i<len(slice);i++{
		if slice[i] == entry {
			return true
		}
	}
	return false
}
//Output:
//true
//false
```

## Get the index of a entry in a slice

```go
package main

import "fmt"

func main() {
	letters := []string{"a", "b", "c", "d"}
	fmt.Println(getSliceIndex(letters, "c"))
	fmt.Println(getSliceIndex(letters, "e"))
}

func getSliceIndex(slice []string, entry string) int{
	for i:=0; i<len(slice);i++{
		if slice[i] == entry {
			return i
		}
	}
	return -1
}
//Output:
//2
//-1
```

## Delete a entry from a slice

```go
package main

import (
	"fmt"
	"log"
	"os"
)

func main() {
	letters := []string{"a", "b", "c", "d"}
	fmt.Println(removeEntryFromSlice(letters, "c"))
	fmt.Println(removeEntryFromSlice(letters, "e"))
}

func getSliceIndex(slice []string, entry string) int{
	for i:=0; i<len(slice);i++{
		if slice[i] == entry {
			return i
		}
	}
	return -1
}

func removeEntryFromSlice(slice []string, entry string) []string{
	i := getSliceIndex(slice, entry)
	if i == -1 {
		log.Printf("The entry %s does not exist in the array", entry)
		os.Exit(1)
	}
	return append(slice[:i], slice[i+1:]...)
}
//Output:
//[a b d]
//2018/03/20 21:18:42 The entry e does not exist in the array
```

[Reference](https://stackoverflow.com/questions/25025409/delete-element-in-a-slice/25025536)