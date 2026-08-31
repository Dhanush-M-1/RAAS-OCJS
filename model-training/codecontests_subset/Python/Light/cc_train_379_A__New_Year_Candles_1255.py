import math
s=input().split()
a=float(s[0])
b=float(s[1])
h=0
while a>=1 :
    h+=math.floor(a)
    a=math.floor(a)/b+a%1
print(h)
