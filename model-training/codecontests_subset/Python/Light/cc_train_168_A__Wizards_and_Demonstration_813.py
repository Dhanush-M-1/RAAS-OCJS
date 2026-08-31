n,x,y=input().split()
n=int(n)
x=int(x)
y=int(y)
import math
needed=math.ceil((n*y)/100)
if(needed>=x):
    print(needed-x)
else:
    print(0)
