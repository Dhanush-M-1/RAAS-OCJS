n = int(input())
a = list(map(int , input().split()))
ans = int(1e6)
ans = min(ans , a[n - 1] - 1)
ans = min(ans , int(1e6) - a[0])
for i in range(0 , n - 1):
    ans = min(ans , max(a[i] - 1 , int(1e6) - a[i + 1]))
print(ans)