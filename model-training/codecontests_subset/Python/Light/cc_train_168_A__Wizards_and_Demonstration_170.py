
import math

a=input()
p=a.split()
n=float(p[0])
x=float(p[1])
y=float(p[2])

out=math.ceil((y/100)*n)

if (int(out-x)>0):
    print (int(out-x))
else:
    print (0)
    



