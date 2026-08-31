import sys
N = int(input())

adj_list = [[] for _ in range(N)]

for _ in range(N-1):
    (u,v) = list(map(int, input().split()))
    u -= 1
    v -= 1
    adj_list[u].append(v)
    adj_list[v].append(u)
num_leaf = 0
for node in range(N):
    if len(adj_list[node]) == 2:
        print("NO")
        sys.exit(0)

print("YES") 
    
