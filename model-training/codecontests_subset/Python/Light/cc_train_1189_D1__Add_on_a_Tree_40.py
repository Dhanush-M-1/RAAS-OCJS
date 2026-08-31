from sys import stdin, stdout, exit

n = int(input())
graph = [[] for i in range(n)]
for i in range(n-1):
    u, v = map(int, stdin.readline().split())
    graph[u-1].append(v-1)
    graph[v-1].append(u-1)

for i in range(n):
    if len(graph[i]) == 2:
        print("NO")
        exit()
print("YES")
