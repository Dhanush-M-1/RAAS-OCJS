def go():
    n = int(input())
    a = list(map(int, input().split()))
    mn, mx = 100000000000, -1
    m = -1
    for i in range(n):
        if i>0 and a[i]!=-1 and a[i-1]!=-1:
            m=max(m,abs(a[i]-a[i-1]))

        if a[i] == -1:
            if i > 0 and a[i-1]!=-1:
                mn = min(mn, a[i - 1])
                mx = max(mx, a[i - 1])
            if i < n - 1 and a[i+1]!=-1:
                mn = min(mn, a[i + 1])
                mx = max(mx, a[i + 1])
    if mx==-1:
        return '0 0'
    k = (mn+mx)//2
    return f"{max(k-mn,mx-k,m)} {k}"

t = int(input())
for _ in range(t):
    print(go())
