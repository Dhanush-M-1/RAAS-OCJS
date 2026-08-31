n,k = map(int,input().split())
buckets = list(map(int,input().split()))

ans = k+1

for i in range(n):
    if buckets[i]*2<=k and k%buckets[i] ==0 or k == buckets[i]:
        ans = min(k//buckets[i],ans)
        
print(ans)
        