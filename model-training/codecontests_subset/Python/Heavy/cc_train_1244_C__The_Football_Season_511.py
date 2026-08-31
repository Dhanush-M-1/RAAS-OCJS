n,p,w,d=map(int,input().split())
if n*w<p or (p>0 and p<d):
    print(-1)
elif (p%w==0 and p//w<=n) or (p%d==0 and p//d<=n):
    if p%w==0:
        print(p//w,0,n-p//w)
    else:
        print(0,p//d,n-p//d)
else:
    total=0
    i=0
    total=int(p/w)*w
    i=int(p/w)
    dif=p-total
    if dif==0:
        print(i,0,n-i)
    elif dif%d==0:
        print(i,dif//d,n-i-dif//d)
    else:
        if w%d==0:
            print(-1)
        else:
            while dif%d!=0:
                dif+=w
                i-=1
            print(i,dif//d,n-i-dif//d)
