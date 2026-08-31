import math
m=0
n,t=[int(i) for i in input().split()]
value=0
while n>=1:
    value+=n
    m=m+n%t
    n=math.floor(n/t)
    if m>=t:
        value+=math.floor(m/t)
        m=1+m%t
    #print(n,m)
print(value)
    
