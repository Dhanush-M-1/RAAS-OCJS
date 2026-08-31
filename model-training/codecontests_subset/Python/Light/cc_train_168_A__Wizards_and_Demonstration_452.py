import math
n,x,y=[int(x) for x in input().split()]
people=math.ceil((y/100)*n)
if(people<=x):
    print(0)
else:
    print(people-x)