import math

n,a,b=list(map(int,input().split()))
x=(n*b)/100
x=math.ceil(x)
if(x>a):
  print(x-a)
else:
  print(0)
