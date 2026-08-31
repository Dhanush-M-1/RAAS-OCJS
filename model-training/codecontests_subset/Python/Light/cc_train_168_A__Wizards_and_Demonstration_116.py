from math import *
n, x, y = input().split()
z = ceil((int(y)/100)*int(n))
if(z > int(x)): s = (z - int(x))
else : s = 0
print(s)

