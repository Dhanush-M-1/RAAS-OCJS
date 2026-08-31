n = int(input())
l = 1
r = 1000000
a = list(map(int, input().split()))
ans = 0
for i in range(n):
    if a[i] - l <= r-a[i]:
        ans = a[i] - 1
    else:
        ans = max(ans, r - a[i])
print(ans)
