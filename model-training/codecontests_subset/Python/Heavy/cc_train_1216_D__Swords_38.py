
def STR(): return list(input())
def INT(): return int(input())
def MAP(): return map(int, input().split())
def MAP2():return map(float,input().split())
def LIST(): return list(map(int, input().split()))
def STRING(): return input()
import string
import sys
from heapq import heappop , heappush
from bisect import *
from collections import deque , Counter , defaultdict
from math import *
from itertools import permutations , accumulate
dx = [-1 , 1 , 0 , 0  ]
dy = [0 , 0  , 1  , - 1]
#visited = [[False for i in range(m)] for j in range(n)]
#sys.stdin = open(r'input.txt' , 'r')
#sys.stdout = open(r'output.txt' , 'w')
#for tt in range(INT()):


#CODE

def gcd(a , b):
    if b == 0 :
        return a
    return gcd(b , a % b)


n = INT()
arr = LIST()
mx = max(arr)

for i in range(n):
    arr[i] = mx - arr[i]

g = gcd(arr[0] , arr[1])
for i in range(2 , n):
    g = gcd(g , arr[i])

cnt = 0
for i in range(n):
    cnt += arr[i] // g

print(cnt  , g)





