n = int(input())
a=list(map(int, input().split()))

res = a[-1]-1
ans  = res
ft = 0
for i in range(n-1, 0, -1):
    res-= (a[i]-a[i-1])
    ft = 10**6-a[i]
    ans = min(ans, max(res, ft))
ft = 10**6-a[0]
ans = min(ans, ft)
print(ans)
    