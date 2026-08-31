import math as m

a,b,c=[int(s) for s in input().split()]
if a==0:
    if b==0:
        if c==0:
            print(-1)
        else:
            print(0)
    else:
        print(1)
        print(-c/b)
else:
    if a<0:
        a,b,c=-a,-b,-c
    d=b**2-4*a*c
    if d>0:
        print(2)
        print((-b-m.sqrt(d))/(2*a))
        print((-b+m.sqrt(d))/(2*a))
    elif d==0:
        print(1)
        print(-b/(2*a))
    else:
        print(0)