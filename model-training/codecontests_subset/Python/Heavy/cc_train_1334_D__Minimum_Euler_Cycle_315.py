for f in range(int(input())):
    n,l,r=map(int,input().split())
    s=[0]*(r-l+1)
    i=1
    p=1
    t=2*n-((2*n)**2-4*l)**0.5
    t=t/2
    t=int(t)
    t-=1
    if t>0:
        p=2*(t*n-(t*(t+1))//2)
        p+=1
        i+=t
    while p+2*(n-i)<=l and i<n:
        p+=2*(n-i)
        i+=1
    j=i+1
    while p+2<=l:
        p+=2
        j+=1
    sm=1
    if p<l:
        sm=0
    for foo in range(r-l+1):
        if sm==1:
            s[foo]=i
            sm=0
        else:
            s[foo]=j
            j+=1
            sm=1
            if j==n+1:
                i+=1
                j=i+1
    if r==n*(n-1)+1:
        s[r-l]=1
    print(*s)