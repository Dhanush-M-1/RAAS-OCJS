n = int(input())
u = list(map(int, list(input())))
k = 0
for i in range(n):
    if u[i] == 8:
        k += 1
ans = 0
ii = -1
for i in range(1, k + 1):
    p = (n - i) // 10
    if min(i, p) > ans:
        ans = min(i, p)
        ii = i
print(ans)
