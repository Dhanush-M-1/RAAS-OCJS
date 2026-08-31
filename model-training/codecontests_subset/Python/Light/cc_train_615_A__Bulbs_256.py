m, n = [int(i) for i in input().split()]
h = {}
for i in range(m):
    _, *arr = [ int(x) for x in input().split()]
    for x in arr:
        h[x] = 1
ans = "YES"
for i in range(1,n+1):
    if h.get(i) is None:
        ans="NO"
        break
print(ans)
