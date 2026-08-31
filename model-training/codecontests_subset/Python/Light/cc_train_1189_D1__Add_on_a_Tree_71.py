n = int(input())
deg = [0 for i in range(n+1)]
for i in range(n-1):
    a,b = [int(j) for j in input().split(" ")]
    deg[a] += 1
    deg[b] += 1

ans = "YES"
for i in range(n+1):
    if deg[i] == 2:
        ans = "NO"
        break
print(ans)