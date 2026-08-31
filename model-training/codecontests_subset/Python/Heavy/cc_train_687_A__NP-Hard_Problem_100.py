'''
@sksshivam007 - Template 1.0
'''
import sys, re, math
from collections import deque, defaultdict, Counter, OrderedDict
from math import ceil, sqrt, hypot, factorial, pi, sin, cos, radians
from heapq import heappush, heappop, heapify, nlargest, nsmallest
def STR(): return list(input())
def INT(): return int(input())
def MAP(): return map(int, input().split())
def LIST(): return list(map(int, input().split()))
def list2d(a, b, c): return [[c] * b for i in range(a)]
def sortListWithIndex(listOfTuples, idx):   return (sorted(listOfTuples, key=lambda x: x[idx]))
def sortDictWithVal(passedDic):
    temp = sorted(passedDic.items(), key=lambda kv: (kv[1], kv[0]))[::-1]
    toret = {}
    for tup in temp:
        toret[tup[0]] = tup[1]
    return toret
def sortDictWithKey(passedDic):
    return dict(OrderedDict(sorted(passedDic.items())))

INF = float('inf')
mod = 10 ** 9 + 7

n,m = MAP()

graph = defaultdict(list)

for _ in range(m):
    u,v = MAP()

    graph[u].append(v)
    graph[v].append(u)

visited = [False]*(n+1)

colorArr = [-1]*(n+1)

for i in range(1, n+1):
    if(visited[i]==False):
        stack = [(i, 0, -1)]    #node, color, parent
        colorArr[i] = 0
        flag = 0
        while(stack):
            popped = stack.pop()
            node = popped[0]
            color = popped[1]
            parent = popped[2]

            visited[node] = True

            for child in graph[node]:
                if(visited[child]==False):
                    stack.append((child, color^1, node))
                    colorArr[child] = color^1
                elif(child!=parent):
                    if(colorArr[child]!=color^1):
                        flag = 1
                        break

            if(flag==1):
                break
        if(flag==1):
            break
if(flag==1):
    print(-1)
else:
    zeros = []
    ones = []
    for i in range(1, n+1):
        if(colorArr[i]==0):
            zeros.append(i)
        else:
            ones.append(i)
    # print(colorArr[1:])

    print(len(zeros))
    print(*zeros)
    print(len(ones))
    print(*ones)
