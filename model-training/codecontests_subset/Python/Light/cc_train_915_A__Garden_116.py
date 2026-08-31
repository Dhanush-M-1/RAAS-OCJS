n, k = map(int, input().split())
a = [int(i) for i in input().split()]
ans = 1e10
for i in range(n):
    if k % (a[i]) == 0 and k // (a[i]) < ans:
        ans = k // (a[i])
print(ans)
