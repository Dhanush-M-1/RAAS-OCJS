try:
    r1,r2=map(int,input().split())
    c1,c2=map(int,input().split())
    d1,d2=map(int,input().split())
    a,b,c,d,=0,0,0,0
    d=int((c2+r2-d2)/2)
    a=int(d1-d)
    b=int(c2-d)
    c=int(r2-d)
    if a!=b and a!=c and a!=d and b!=c and b!=d and c!=d and 0<a<10 and 0<b<10 and 0<c<10 and 0<d<10 and a+b==r1 and a+d==d1 and a+c==c1 and b+d==c2 and c+d==r2 and b+c==d2:
            print(a,b)
            print(c,d)
    else:
        print(-1)
except:
    pass
