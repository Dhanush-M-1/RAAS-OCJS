from decimal import *
from math import log
getcontext().prec=500
x,y,z=map(Decimal,input().split())
a,l=[],[]
l.append("")
l.append("x^y^z")
l.append("x^z^y")
l.append("(x^y)^z")
l.append("(x^z)^y")
l.append("y^x^z")
l.append("y^z^x")
l.append("(y^x)^z")
l.append("(y^z)^x")
l.append("z^x^y")
l.append("z^y^x")
l.append("(z^x)^y")
l.append("(z^y)^x")
a = [Decimal(0) for i in range(13)]
a[1]=Decimal(log(x))*(y**z)
a[2]=Decimal(log(x))*(z**y)
a[3]=Decimal(log(x))*(z*y)
a[4]=a[3]
a[5]=Decimal(log(y))*(x**z)
a[6]=Decimal(log(y))*(z**x)
a[7]=Decimal(log(y))*(x*z)
a[8]=a[7]
a[9]=Decimal(log(z))*(x**y)
a[10]=Decimal(log(z))*(y**x)
a[11]=Decimal(log(z))*(x*y)
a[12]=a[11]

mx=Decimal(-10**999)
pos=0
for i in range(1,13):
	if a[i]>mx:
		pos=i
		mx=a[i]
print(l[pos])