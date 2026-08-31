from collections import defaultdict, deque
from itertools import permutations
from sys import stdin, stdout
from bisect import bisect_left, bisect_right
from copy import deepcopy


MOD = pow(10, 9)+7

test = int(stdin.readline())

set1 = []
n = 0


def dfs(graph, start, forbidden):
    Stack = [start]
    result = set([])
    visited = [False]*(n+1)
    while(Stack):
        children = Stack.pop()
        for items in graph[children]:
            if items == forbidden or visited[items]:
                continue
            else:
                visited[items] = True
                result.add(items)
                Stack.append(items)

    return result-{start}


for _ in range(test):

    n, m, a, b = map(int, stdin.readline().split())
    graph = {}
    for i in range(1, n+1):
        graph[i] = []
    for i in range(m):
        u, v = map(int, stdin.readline().split())
        graph[u].append(v)
        graph[v].append(u)

    result1 = dfs(graph, a, b)
    result2 = dfs(graph, b, a)

    print((len(result1-result2))*(len(result2-result1)))
