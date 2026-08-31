x=list(map(int, input().split()))
a=x[0]
b=x[1]
c=x[2]
import math
if a==0:
    if b==0:
        if c==0:
            print(-1)
        else:
            print(0)
    else:
        print(1)
        if c!=0:
            r=-c/b
        else:
            r=abs(c/b)
        print("{:.10f}".format(r))
else:
    d=(b*b)-(4*a*c)
    if d<0:
        print(0)
    elif d==0:
        print(1)
        r=(-b)/(2*a)
        print("{:.10f}".format(r))
    else:
        r1=math.sqrt(d)
        r11=(-b+r1)/(2*a)
        r12=(-b-r1)/(2*a)
        r=[]
        r.append(min(r11,r12))
        r.append(max(r11,r12))
        print(2)
        for i in r:
            print("{:.10f}".format(i))