"""
Consider a permutation p of length n, we build a graph of size n using it as follows:

For every 1≤i≤n, find the largest j such that 1≤j<i and pj>pi, and add an undirected edge between node i and node j
For every 1≤i≤n, find the smallest j such that i<j≤n and pj>pi, and add an undirected edge between node i and node j

For clarity, consider as an example n=4, and p=[3,1,4,2]; here, the edges of the graph are (1,3),(2,1),(2,3),(4,3).

A permutation p is cyclic if the graph built using p has at least one simple cycle.i.e if there exists atleast one index which contains nodes on both lhs and rhs.

soln:

ans = n! - 2^(n-1)
#total permutations - unimodal permutations
"""

def fact(n,p):
    if n < 2 :
        return 1
    else:
        res = 1
        while(n):
            res = ((res % p)*(n % p)) % p  
            n = ((n % p) - 1) % p
    return res 

def power(x, y, p) : 
    res = 1   
    x = x % p  
      
    if (x == 0) : 
        return 0
  
    while (y > 0) : 
        # if y is odd
        if ((y & 1) == 1) : 
            res = (res * x) % p 
  
        y = y >> 1      # y = y/2 
        x = (x * x) % p 
          
    return res 

n = int(input())
p = pow(10,9)+7
out = ((fact(n,p)%p)-(power(2,n-1,p)%p))%p
print(out)



