from math import *
n1=input()
a=n1.split()
n=int(a[0])
x=int(a[1])
y=int(a[2])
k=(y/100)*n
y=int(ceil(k))
if y > x:
    print(y-x)
else:
    print("0")
