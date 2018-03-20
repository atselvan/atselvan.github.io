# Modify Usage flag in go

This can be done by modifying flag.Usage function.

```go
flag.Usage = func() {
    fmt.Fprintf(os.Stderr, "Print the Usage.\n")
}
```

Example code:

```go
package main

import (
    "flag"
    "fmt"
    "os"
)

func main() {
    PrintHelp()
}

func PrintHelp() {
    helpString := `
     Usage: ./nexus-repository-cli.exe [required prameters] [option] [parameters...]

     [Required Prameters]:
     -nexusUrl string
         Nexus server URL (default "http://localhost:8081/nexus")
     -username string
            Username for authentication
      -password string
            Password for authentication

     [options]
      -list
            List the repositories in Nexus. Optional parameters: repoType, repoPolicy

     [parameters]
      -repoType string
            Type of a repository. Possible values : hosted/proxy/group
      -repoPolicy string
            Policy of the hosted repository. Possible values : snapshot/release
      -verbose
            Set this flag for Debug logs.
    `
    flag.Usage = func() {
        fmt.Fprintf(os.Stderr, helpString)
    }
    flag.Usage()
}
```