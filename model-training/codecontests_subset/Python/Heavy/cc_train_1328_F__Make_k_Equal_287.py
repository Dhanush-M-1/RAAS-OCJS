n,k=map(int,input().split())
a=list(map(int,input().split()))
dp=[[] for i in range(200005)]
mp={}
cnt=0
for i in a:
    if i not in mp:
        mp[i]=0
    else:
        mp[i] += 1
        cnt=max(cnt,mp[i])
if cnt >= k:
    print(0)
else:
    for i in a:
        cnt=0
        x=i
        while x:
            dp[x].append(cnt)
            x=x//2
            cnt += 1
        dp[x].append(cnt)
    ans=10000000000000000000000000000000000000000000000
    for i in range(200005):
        if len(dp[i])<k:
            continue
        else:
            cnt=0
            dp[i]=sorted(dp[i])
            for j in range(k):
                cnt += dp[i][j]
            ans=min(ans,cnt)
    print(ans)