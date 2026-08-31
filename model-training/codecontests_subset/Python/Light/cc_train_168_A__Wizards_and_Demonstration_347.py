n,x,y=map(int,input().split())
a=(y*n)
if (a%100)==0:
    a=a//100
else:
    a=a//100+1
if (x>=a):
    print("0")
else:
    print(abs(x-a))