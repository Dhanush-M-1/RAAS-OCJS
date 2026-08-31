import sys
cases = int(input())
for t in range(cases):
    n = int(input())
    a = list(map(int,input().split()))
    a1 = []
    ans = 0
    for i in range(n):
        if a[i]!=-1:
            if (i>0 and a[i-1]==-1) or (i<n-1 and a[i+1]==-1):
                a1.append(a[i])
            if (i<n-1) and (a[i+1]>-1):
                ans = max(ans,abs(a[i]-a[i+1]))
    if not a1:
        a1.append(0)
    maxv = max(a1)
    minv = min(a1)
    k = (minv+maxv)//2
    ans = max(maxv-k,ans)
    print(ans,k)