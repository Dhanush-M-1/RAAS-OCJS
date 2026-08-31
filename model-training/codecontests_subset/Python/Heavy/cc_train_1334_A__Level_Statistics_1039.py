t=int(input())
for _ in range(t):
    n=int(input())
    p,c=[],[]
    for i in range(n):
        a,b=map(int,input().split())
        p.append(a)
        c.append(b)
    exisp,exisc=0,0
    ans=True
    for i in range(n):
        if p[i]<exisp:
            ans=False
            break
        if c[i]<exisc:
            ans=False
            break
        if c[i]>p[i]:
            ans=False
            break
        if p[i]-exisp<c[i]-exisc:
            ans=False
            break
        exisc=c[i]
        exisp=p[i]
    if ans:
        print("YES")
    else:
        print("NO")