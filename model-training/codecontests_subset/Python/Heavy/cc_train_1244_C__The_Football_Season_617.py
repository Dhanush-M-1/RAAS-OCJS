from math import *



def egcd(a, b):
	if a == 0:
		return (b, 0, 1)
	else:
		gcd, x, y = egcd(b % a, a)
		return (gcd, y - (b//a) * x, x)


he=input()
he2=[int(n) for n in he.split()]
n=he2[0]
p=he2[1]
w=he2[2]
d=he2[3]



g, x, y = egcd(w, d)
# print(g,x,y)
if(p%g!=0):
    print("-1\n")
    exit(0)
else:
	x=int(x*int(p//g))
	y=int(y*int(p//g))
	

    
k1=(d//g)
k2=(w//g)



if(x>=0):
    t=floor(x//(k1))
    x=(x%k1)
    y=y+int(t*k2)

if(y>0):
    t=floor(y//(k2))
    y=y%k2
    x=x+int(t*k1)


if(x>=0 and y>=0):

    t=y//(k2)
    y%=k2
    x+=(t*k1)

    if(x+y<=n):
        print(int(x),int(y),int(n-x-y))
    else:
        print("-1\n")
    
else:
    print("-1\n")




