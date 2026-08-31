import math
a,b,c=map(int,input().split())
if (a==0 and b==0 and c==0):
    print(-1)
elif(a==0 and b==0 and c!=0):
    print(0)
elif (a==0 and b!=0):
    print(1)
    print(-c/b)
elif (b*b-4*a*c<0):
    print(0)
elif (b*b-4*a*c==0):
    print(1)
    print((-b/(2*a)))
else:
    print(2)
    d=(-b+math.sqrt(b*b-4*a*c))/(2*a)
    e=(-b-math.sqrt(b*b-4*a*c))/(2*a)
    print(min(e,d))
    print(max(e,d))