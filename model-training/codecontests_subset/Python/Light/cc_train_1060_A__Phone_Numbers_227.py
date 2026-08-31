import math
n=int(input())
l=str(input())
x=l.count("8")
y=math.floor(n/11)
if x==0 or n<11:
    print(0)
elif y>x:
    print(x)
else:
    print(y)
    