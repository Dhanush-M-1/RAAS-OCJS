n, m = map(int, input().split())
v = m * [0]
for i in range(n):
    a = list(map(int, input().split()))
    a.pop(0)
    for j in a : v[j - 1] = 1
if v == m * [1] : print("YES")
else : print("NO")
