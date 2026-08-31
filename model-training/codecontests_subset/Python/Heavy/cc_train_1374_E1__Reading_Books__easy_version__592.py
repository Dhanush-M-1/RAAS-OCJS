from sys import stdin, setrecursionlimit, stdout
#setrecursionlimit(1000000)
from collections import deque
from math import sqrt, floor, ceil, log, log2, log10, pi, gcd, sin, cos, asin
from heapq import heapify, heappop, heappush, heappushpop, heapreplace
def ii(): return int(stdin.readline())
def fi(): return float(stdin.readline())
def mi(): return map(int, stdin.readline().split())
def fmi(): return map(float, stdin.readline().split())
def li(): return list(mi())
def si(): return stdin.readline().rstrip()
def lsi(): return list(si())
#mod=1000000007
res=['YES', 'NO']
############# CODE STARTS HERE #############




test_case=1
while test_case:
    test_case-=1


    n, k=mi()
    both=[0]
    al=[0]
    bob=[0]
    for _ in range(n):
        x, y, z=mi()
        if y and z:
            both.append(x)
        elif y:
            al.append(x)
        elif z:
            bob.append(x)
    both.sort()
    for i in range(1, len(both)):
        both[i]+=both[i-1]
    al.sort()
    for i in range(1, len(al)):
        al[i]+=al[i-1]
    bob.sort()
    for i in range(1, len(bob)):
        bob[i]+=bob[i-1]

    ans=1000000000000000000000000000

    #print(both)
    #print(al)
    #print(bob)
    for i in range(len(both)):
        if len(al)>k-i and len(bob)>k-i:
            ans=min(ans, both[i]+al[k-i]+bob[k-i])
        #print(both[:i]+al[:k-i]+bob[:k-i])
        if i==k:
            ans=min(ans, both[i])
            break
    #print(ans)
    print(-1 if ans==1000000000000000000000000000 else ans)

