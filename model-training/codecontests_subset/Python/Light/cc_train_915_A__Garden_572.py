n , k = map(int, input().split())
bucket = list(map(int, input().split()))
bucket.sort(reverse= True)
ans = 0
for i in bucket:
    if k%i==0:
        ans=k//i
        print(ans)
        break