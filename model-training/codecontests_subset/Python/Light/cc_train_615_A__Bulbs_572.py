n, m = map(int, input().split())
L = [list(map(int, input().split())) for _ in range(n)]
T = []
for i in range(n):
    T += L[i][1:]
ok = 1
for i in range(m):
    if T.count(i+1) == 0:
        ok = 0
        print("NO")
        break
if ok:
    print("YES")
