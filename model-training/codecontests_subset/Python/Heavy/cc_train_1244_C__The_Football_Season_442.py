def gcdExtended(a, b): 
	global x,y
	if(a==0):
		x=0
		y=1
		return b
	gcd=gcdExtended(b%a,a)
	x1=x
	y1=y
	x=y1-(b//a)*x1
	y=x1
	return gcd

def min(a,b):
	if(a>b):
		return b
	return a

def max(a,b):
	if(a<b):
		return b
	return a

def produce(x,y,w2,d2,swap):
	lb=0
	ub=100000000000000000000000000
	lb=max(lb,(-x+d2-1)//d2)
	ub=min(ub,(n-x)//d2)
	ub=min(ub,(n-x)//d2)
	lb=max(lb,(y-n+w2-1)//w2)
	if(d2-w2>0):
		ub=min(ub, (n-x-y)//(d2-w2))
		lb=max(lb, (-x-y+d2-w2-1)//(d2-w2))
	elif(w2-d2>0):
		ub=min(ub, (x+y)//(w2-d2))
		lb=max(lb, (x+y-n+w2-d2-1)//(w2-d2))
	if(lb<=ub):
		v1=x+lb*d2
		v2= y-lb*w2
		v3=n-v1-v2
		if(v1>=0 and v2>=0 and v3>=0):
			if(not swap):
				print(v1,v2,v3)
				return True
			else:
				print(v2,v1,v3)
				return True
	return False

n,p,w,d=map(int,input().split())
x=1
y=1
g=gcdExtended(w,d)
if(not p%g==0):
	print(-1)
else:
	p=p//g
	w2=w//g
	d2=d//g
	x=x*p
	y=y*p
	if(not produce(x,y,w2,d2,False)):
		if(not produce(y,x,d2,w2,True)):
			print(-1)
	
	