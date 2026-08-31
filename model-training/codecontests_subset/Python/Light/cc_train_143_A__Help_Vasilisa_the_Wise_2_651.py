


r1,r2 = map(int,input().split())
c1,c2= map(int,input().split())
d1,d2=map(int,input().split())



d = (d1-c1+r2)

if d%2==0:
    D=d//2
    c=r2-D
    b = c2-D
    a = r1-b
    if 9>=a>0 and 9>=b>0 and 9>=c>0 and 9>=D>0:
        if len(set([a,b,c,D]))==4:
            print(a,b)
            print(c,D)
        else:
            print(-1)
    else:
        print(-1)
else:
    print(-1)
