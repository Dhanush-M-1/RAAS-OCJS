
def STR(): return list(input())
def INT(): return int(input())
def MAP(): return map(int, input().split())
def MAP2():return map(float,input().split())
def LIST(): return list(map(int, input().split()))
def STRING(): return input()
from heapq import heappop , heappush
from bisect import *
from collections import deque , Counter
from math import *
from itertools import permutations
dx = [-1 , 1 , 0 , 0  ]
dy = [0 , 0  , 1  , - 1]
#visited = [[False for i in range(m)] for j in range(n)]
#for tt in range(INT()):

def lcm(a , b):
    return (a * b) // gcd(a , b)

def pfs(n):
    a = []
    i = 1
    while i * i <= n :
        if n % i == 0 :
            if n // i == i :
                a.append(i)
            else:
                a.append(i)
                a.append(n//i)
        i+=1

    return a

x = INT()
if x == 1 :
    print(1 , 1)
    exit(0)
r = pfs(x)
ans = []

for i in range(len(r)):
    if lcm(r[i] , x//r[i]) == x :
        ans.append([r[i] , x//r[i] , (r[i] + (x//r[i]))])

ans = sorted(ans , key= lambda x :x[2])
#print(ans)
z = ans[0]
print(z[0] , z[1])
