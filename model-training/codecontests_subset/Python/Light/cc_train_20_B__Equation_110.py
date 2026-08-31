from math import sqrt
a,b,c=list(map(int,input().split()))
if a==b==c==0:
    print(-1)
else:
    if a==0:
        if b!=0:
            print(1)
            print(-c/b)
        else:
            print(0)
    else:
        d=b**2-4*a*c
        if d<0:
            print(0)
        elif d==0:
            print(1)
            print(-b/2/a)
        else:
            print(2)
            e=(-b-sqrt(d))/2/a
            f=(-b+sqrt(d))/2/a
            print(min(e,f))
            print(max(e,f))