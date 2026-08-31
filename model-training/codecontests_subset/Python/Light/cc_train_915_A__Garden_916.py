n, k  = map(int, input().split())
arr = list(map(int, input().split()))
ans = 1
for i in arr: 
    if k % i == 0: ans = max(ans, i)
print(k // ans)