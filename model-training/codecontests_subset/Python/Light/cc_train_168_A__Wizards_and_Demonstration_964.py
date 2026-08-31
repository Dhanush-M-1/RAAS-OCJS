import math
z=list(map(int,input().split()))
n=z[0]
x=z[1]
y=z[2]
c=(x/n)

c=c*100
c=round(c,4)

if(c>=y):
    print(0)
else:
    
    p=(((y-c)*n)/100)

    print(math.ceil(p))
