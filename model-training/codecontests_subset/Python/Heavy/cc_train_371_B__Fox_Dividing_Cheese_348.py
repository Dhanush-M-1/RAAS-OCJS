from math import gcd, sqrt
from math import log
from os import path

def factorization235(n):
    c,result = 0,1
    while n % 2 == 0:
        n /= 2; c += 1;
    while n % 3 == 0:
        n /= 3; c += 1
    while n % 5 == 0:
        n /= 5; c += 1
    if n != 1: return -1
    return c

a,b = map(int,input().split(' '))
path1,path2,div = 0,0,True
if a == b: pass
else:
    target = gcd(a,b)
    path1 = a / target; path2 = b / target
    if path1 != 1:
        path1 = factorization235(path1)
        if path1 == -1: div = False
    else: path1 = 0
    if path2 != 1:
        path2 = factorization235(path2)
        if path2 == -1: div = False
    else: path2 = 0
if div: print(int(path1 + path2))
else: print(-1)

'''
If we want to reach the same number decreasing a and b by
division we have to check for GCD(a,b). GCD because our goal is also 
to minimize the number of operations, so we target the first 
common number like that.

If we are confident that both numbers will meet each other
at GCD and not earlier than we should just figure out the shortest "div" path
from both numbers to GCD and sum it up.
If it's impossible to reach GCD with 
problem div conditions from any num than return -1.

Operations: if you divide (a,b) / GCD(a,b) you will get the path which you have to 
decrease by the division to get to GCD(a,b) from a or b. Division is only allowed by 2,3,5.
The goal here is to construct this division only from these numbers, to do that we will
do prime factorization for only 2,3,5. Number of prime factors will be the number of operations.
'''