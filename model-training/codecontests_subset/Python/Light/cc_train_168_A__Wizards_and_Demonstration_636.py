import math
a,b,c=map(int,input().split())
p=math.ceil((c*a)/100)
if p<=b:print(0)
else:print(p-b)