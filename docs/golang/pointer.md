# Pointers in GO

## What are Pointers

A pointer is a variable whose value is the address of another variable, i.e., direct address of the memory location.

## How to Use Pointers

There are a few important operations, which we will do with the help of pointers very frequently. 

* (a) We define a pointer variable
* (b) assign the address of a variable to a pointer and
* (c) finally access the value at the address available in the pointer variable. 

This is done by using unary operator * that returns the value of the variable located at the address specified by its operand

The type *T is a pointer to a T value. Its zero value is nil

## Example

```go
package main

import "fmt"

func main() {

    var(
        i int
        p *int
        b int
    )
    i = 3511
    p = &i //The & operator generates a pointer to its operand
    b = *p //The * operator denotes the pointer's underlying value

    fmt.Println("Value if 'i' is ", i)
    fmt.Println("Pointer of 'i' is ", p)
    fmt.Println("Value of Pointer p is ", b)

    *p = 21         // set i through the pointer p
    //This is known as "dereferencing" or "indirecting"

    fmt.Println("Value of Pointer p is ", *p)
}
```

Unlike C, Go has no pointer arithmetic