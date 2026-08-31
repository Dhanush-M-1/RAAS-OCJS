import math
n,x,y = map(int, input() .split())
t = math.ceil((y/100) * n)
if x > t :
  print(0)
else: 
  print(t-x)  