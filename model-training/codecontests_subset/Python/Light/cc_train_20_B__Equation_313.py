import math
a,b,c=map(int,input().split())
if a==0:
    if b==0 and c!=0:
        print(0)
    elif b==0 and c==0:
        print(-1)
    else:
        x=-c/b
        print(1)
        print("%.10f" %x)
else:
    d=b*b-4*a*c
    if d<0:
        print(0)
    else:
        if d>0:
            ans=[]
            ans.append((-b+math.sqrt(d))/(2*a))
            ans.append((-b-math.sqrt(d))/(2*a))
            print(2)
            ans.sort()
            print("%.10f" %ans[0])
            print("%.10f" %ans[1])
        else:
            y=((-b-math.sqrt(d))/(2*a))
            print(1)
            print("%.10f" %y)