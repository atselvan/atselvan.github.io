# Raft Consensus Algorithm

Read about the algorithm via the below links:

[Raft Consensus Algorithm - Github](https://raft.github.io/)

[Blog on Medium](https://medium.com/@amangoeliitb/raft-consensus-algorithm-d93e7ee22b12)

## Why odd number of nodes?

The reason is that in a distributed transactional system with a raft algorithm you need a quorum ( majority ). Essentially a transaction is committed once more than 50% of nodes say that the transaction is committed.

You could do 4 nodes as well but you would not get any benefit over 3 nodes and you add additional overhead. 4 Nodescan only survive 1 failed node because 3 nodes are a majority and not 2. Therefore you need an uneven number. 3 nodes can survive 1 failure, 5 nodes can survive 2 failures, 7 nodes can survive 3 failures and so on...

Just imagine how many node failures your cluster can tolerate. Formula is:

```
Number of node failures that can be tolerated = Round (N/2) - 1
```

Applying the above formula for your cluster it is Round (5/2) – 1 =  2 Nodes.  Now say we had 6 nodes instead of 5.Re-applying the formula gives you Round(6/2) – 1 = 2 Nodes again.  So the extra node doesn’t add any tangible benefitfor the cluster. So replicating to that one extra node is just a performance overhead.

Other way to put it, when you are thinking about availability and fault tolerance of your cluster, just think howmany node failures do you want your cluster to tolerate.  If you want N failures to tolerate, then you need 2N + 1nodes in your cluster. Apply this to our case, say, we wanted to tolerate 2 failures hence we have 2(2) + 1 = 5 nodesin our cluster. if you want a 3 node failure to be tolerated it will 2(3) + 1 = 7. This only goes as odd numbers.