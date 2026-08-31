n, k = map(int, input().split())
a = list(map(int, input().split()))
ans = 100000
for N in a:
    if k % N == 0:
        ans = min(ans, k // N)
print(ans)
