for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    mx,mn = -float('inf'),float('inf')
    for i in range(n):
        if i>0 and a[i] == -1 and a[i-1]!=-1:
            mx,mn = max(mx,a[i-1]),min(mn,a[i-1])
        if i<n-1 and a[i] == -1 and a[i+1] != -1:
            mn,mx = min(mn,a[i+1]),max(mx,a[i+1])
    if mx == -float('inf') or mn == float("inf"):
        ans = 0
    else:
        ans = (mx+mn)//2
    m = 0
    for i in range(n):
        if a[i] == -1:
            a[i] = ans
        if i > 0:
            m = max(m,abs(a[i]-a[i-1]))
    print(m,ans)