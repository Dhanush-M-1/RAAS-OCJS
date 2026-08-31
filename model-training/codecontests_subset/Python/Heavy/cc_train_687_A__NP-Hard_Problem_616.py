import bisect
import collections
import copy
import functools
import heapq
import itertools
import math
import random
import re
import sys
import time
import string
from typing import List
# sys.setrecursionlimit(999)

n,m = map(int,input().split())
edges = []
half = 100002
tree = list(range(200005))

def find(x):
    if tree[x]!=x:
        tree[x] = find(tree[x])
    return tree[x]
def connect(x,y):
    tree[find(x)] = find(y+half)
    tree[find(y)] = find(x+half)

for _ in range(m):
    u,v = map(int,input().split())
    edges.append([u,v])
    connect(u,v)

ans = [set(),set()]
s = {}
for u,v in edges:
    fu,fv = map(find,(u,v))
    if fu==fv:
        print(-1)
        exit(0)
    elif fu in s and fv in s:
        ans[s[fu]].add(u)
        ans[s[fv]].add(v)
    elif fv in s:
        ans[s[fv]].add(v)
        ans[1-s[fv]].add(u)
        s[fu] = 1-s[fv]
    elif fu in s:
        ans[s[fu]].add(u)
        ans[1-s[fu]].add(v)
        s[fv]= 1-s[fu]
    else:
        ans[0].add(u)
        ans[1].add(v)
        s[fu] = 0
        s[fv] = 1
    
print(len(ans[0]))
print(*ans[0])
print(len(ans[1]))
print(*ans[1])
