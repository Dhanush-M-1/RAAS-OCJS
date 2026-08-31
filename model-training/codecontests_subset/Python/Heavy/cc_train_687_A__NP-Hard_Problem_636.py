#   In this template you are not required to write code in main

import sys
inf = float("inf")

#sys.setrecursionlimit(1000000)
#from cmath import sqrt
#from collections import deque, Counter, OrderedDict,defaultdict
#from heapq import nsmallest, nlargest, heapify,heappop ,heappush, heapreplace
#from math import ceil,floor,log,sqrt,factorial,pow,pi,gcd
#from bisect import bisect_left,bisect_right

abc='abcdefghijklmnopqrstuvwxyz'
abd={'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4, 'f': 5, 'g': 6, 'h': 7, 'i': 8, 'j': 9, 'k': 10, 'l': 11, 'm': 12, 'n': 13, 'o': 14, 'p': 15, 'q': 16, 'r': 17, 's': 18, 't': 19, 'u': 20, 'v': 21, 'w': 22, 'x': 23, 'y': 24, 'z': 25}
mod,MOD=1000000007,998244353
vow=['a','e','i','o','u']
dx,dy=[-1,1,0,0],[0,0,1,-1]

def is_bipartite(graph):
    n = len(graph)
    color = [-1] * n

    for start in range(n):
        if color[start] == -1:
            color[start] = 0
            stack = [start]

            while stack:
                parent = stack.pop()

                for child in graph[parent]:
                    if color[child] == -1:
                        color[child] = 1 - color[parent]
                        stack.append(child)
                    elif color[parent] == color[child]:
                        return False, color

    return True, color


def get_array(): return list(map(int, sys.stdin.readline().strip().split()))
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def input(): return sys.stdin.readline().strip()

n,m=get_ints()
mydict={i:[] for i in range(n)}
for i in range(m):
    x,y=get_ints()
    mydict[x-1].append(y-1)
    mydict[y-1].append(x-1)
ans,color=is_bipartite(mydict)
if not ans:
    print(-1)
else:
    result1=[];result2=[]
    for i in range(n):
        if color[i]==0:
            result1.append(i+1)
        else:
            result2.append(i+1)
    print(len(result1))
    print(*result1)
    print(len(result2))
    print(*result2)
