
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

for tt in range(INT()):
    n = INT()
    arr = []
    for i in range(n):
        l , r = MAP()
        arr.append([l , r])

    if n == 1 :
        print(0)

    else:
        arr.sort(key=lambda x : x[1])
        s_end = arr[0][1]
        arr.sort(key=lambda x :x[0] , reverse=True)
        b_start = arr[0][0]
        #print(s_end , b_start)
        ans = (b_start - s_end)
        if ans < 0 :
            print(0)
        else:
            print(ans)


