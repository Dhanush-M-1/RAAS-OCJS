n, k = map(int, input().split())
a = list(map(int, input().split()))
ans = 10000000
for i in a:
    if k % i == 0:
        ans = min(ans, k//i)
print(ans)