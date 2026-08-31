import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
graph = {}
for i in range(1, n+1): graph[i] = []
for i in range(1, n):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(1, n+1):
    if len(graph[i])==2:
        print("NO")
        break
else: print("YES")
