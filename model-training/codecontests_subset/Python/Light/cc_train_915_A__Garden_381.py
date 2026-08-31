n, k = map(int, input().split())
a = list(map(int, input().split()))
ans = 100
for i in range(n):
    if k % a[i] == 0:
        ans = min(ans, k // a[i])
print(ans)
