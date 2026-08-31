def gcdExtended(a, b, x, y): 
	if a == 0:
		x = 0
		y = 1
		return b,x,y
	x1 = 1
	y1 = 1
	gcd,x1,y1 = gcdExtended(b%a, a, x1, y1) 
  
	x = y1 - (b//a) * x1
	y = x1 
	return gcd,x,y 

def find_one(a,b,c,g):
	g,x0,y0 = gcdExtended(a,b,0,0)
	
	x0 *= c // g
	y0 *= c // g
	if a < 0:
		x0 = -x0
	if b < 0:
		y0 = -y0
	return x0,y0


def gcd(a,b):
	if(b == 0):
		return a
	return gcd(b,a%b)
  
n,p,w,d = map(int,input().split())
g = gcd(w,d)
if(p % g):
	print("-1")
else:
	a,b = find_one(w,d,p,g)
	p1 = w//g
	p2 = d//g
	l = -1e30
	r = 1e30
	while(l <= r):
		mid = int((l+r)//2)
		x = a + mid*p2
		y = b - mid*p1
		if(x >= 0 and y >= 0 and ((x+y) <= n)):
			print(int(x),int(y),int(n-x-y))
			exit(0)
		elif(x < 0):
			l = mid+1;
		elif(y < 0):
			r = mid-1;
		elif(x + y > n):
			l = mid+1;
	print("-1")
