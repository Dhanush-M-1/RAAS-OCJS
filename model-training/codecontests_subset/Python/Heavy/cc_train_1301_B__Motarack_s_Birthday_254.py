for _ in range(int(input())):
    n=int(input()); mn=10000000000; mx=-1
    inp=[int(i) for i in input().split()]
    for i in range(n):
        if inp[i]!=-1:
            if i>0 and inp[i-1]==-1:
                mn=min(mn, inp[i])
                mx=max(mx, inp[i])
            if i<n-1 and inp[i+1]==-1:
                mn=min(mn, inp[i])
                mx=max(mx, inp[i])
    if mx==-1:
        k=0
    else:
        k=(mx+mn)//2
    ans=0
    if inp[0]==-1:
        inp[0]=k
    for i in range(1, n):
        if inp[i]==-1:
            inp[i]=k
        ans=max(ans, abs(inp[i]-inp[i-1]))
    print(ans, k)
