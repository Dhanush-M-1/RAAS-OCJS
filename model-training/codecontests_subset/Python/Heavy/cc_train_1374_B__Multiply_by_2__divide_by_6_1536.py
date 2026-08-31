import math
from decimal import *
getcontext().prec = 30
t=int(input())
while t:
    t-=1
    n=int(input())
    if n==1:
        print(0)
        continue
    if n%3:
        print(-1)
        continue
    if n==6 or n==3:
        print(6//n)
        continue
    if n%9:
        print(-1)
        continue
    x=3
    six=1
    while n%x==0:
        x*=3
        six*=6
    #print(six,n)
    if six%n:
        print(-1)
        continue
    ans=math.log(six//n,2)+math.log(six,6)
    print(int(ans))



