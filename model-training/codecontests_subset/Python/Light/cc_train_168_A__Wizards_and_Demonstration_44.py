import math
n,x,y=map(int,input().split())
d=math.ceil((y/100)*n)
if(int(d)>x):
    print(int(d)-x)
elif(int(d)<=x):
    print(0)
