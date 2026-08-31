for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    c=l[n-1]
    ok=False
    p,q,r=0,0,0
    for i in range(1,n-1):
        if l[i]+l[i-1]<= c:
            p,q=i,i-1
            ok=True
    if(ok):
        print(q+1,p+1,n)
    else:
        print("-1")