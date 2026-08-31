import math
a,b,c=map(int,input().split())
if a:
    if b*b-4*a*c>0:
        print(2)
        print(min((-b-math.sqrt(b*b-4*a*c))/2/a,(-b+math.sqrt(b*b-4*a*c))/2/a))
        print(max((-b-math.sqrt(b*b-4*a*c))/2/a,(-b+math.sqrt(b*b-4*a*c))/2/a))
    elif b*b-4*a*c==0:
        print(1)
        print(round(-b/2/a,5))
    else:
        print(0)
elif b:
    print(1)
    print(-c/b)
else:
    print(0 if c else -1)
    