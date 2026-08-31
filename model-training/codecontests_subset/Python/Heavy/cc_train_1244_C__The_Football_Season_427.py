import math

def egcd(a,b):
	if a==0:
		return (b,0,1)
	else:
		gcd,x,y=egcd(b%a,a)
		return (gcd,y-(b//a)*x,x)

n,p,w,d=map(int,input().split())
g,x0,y0=egcd(w,d)
# print(g,)
if(p%g):
	print(-1)
	exit(0)
x0*=(p//g)
y0*=(p//g)
# print(x0*w+y0*d)
# print(x0,y0)
minn=max(-x0*g/d,(x0+y0-n)*g/(w-d))
maxx=y0*g/w
# print(minn,maxx)
l=math.ceil(minn)
r=math.floor(maxx)
# print(l,r)
if r<l:
	print(-1)
	exit(0)
for i in range(l,r+1):
	x=(x0+i*d//g)
	y=(y0-i*w//g)
	z=n-x-y
	if x>=0 and y>=0 and z>=0:
		print((x),y,int(z))
		exit(0)
print(-1)