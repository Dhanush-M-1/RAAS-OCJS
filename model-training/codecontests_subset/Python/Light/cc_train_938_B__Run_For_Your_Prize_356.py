n = int(input())
a = list(map(int, input().split()))

ub = 10**6
lb = 1

ans = min(a[n-1] - lb, ub - a[0])
for i in range(1,n):
    ans = min(ans, max(a[i-1]-lb, ub - a[i]))

print(ans)