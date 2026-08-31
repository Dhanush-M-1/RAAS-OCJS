from collections import defaultdict
n = int(input())
tr = defaultdict(int)
for i in range(n-1):
    u, v = map(int, input().split())
    tr[u]+=1
    tr[v]+=1
for i in tr:
    if tr[i]==2:
        print("NO")
        break
else:
    print("YES")