def fastpow(a, p, m):
	if a==0:
		return 1
	t=fastpow(a,p//2)
	return t*t*(a if a%2 else 1)

def xgcd(a,b):
	if b==0:
		return (1,0,abs(a))
	x,y,g=xgcd(b,a%b)
	return (y,x-(a//b)*y,g);

def adjust_xgcd_lb(x,y,g,a,b,lbx,lby):
	if x<lbx:
		t=0
		if b>=0:
			t=(lbx-x)*g//b + int((lbx-x)*g%b!=0)
		else:
			t=(lbx-x)*g//b
		x+=t*b//g;
		y-=t*a//g;
	if y<lby:
		t=0
		if a>=0:
			t=(lby-y)*g//a + int((lby-y)*g%a!=0)
		else:
			t=(lby-y)*g//a
		x-=t*b//g;
		y+=t*a//g;
	#if x<lbx or y<lby:
	#	raise Exception;
	return (x,y);

n,p,w,d=map(int,input().split())
x,y,g=xgcd(w,d)

if p%g:
  print(-1)
  exit(0)
x*=p//g
y*=p//g

x,y=adjust_xgcd_lb(x,y,g,w,d,0,0)
if n-(x+y)<0:
  t=(n-(x+y))*g//(d-w) + int((n-(x+y))*g%(d-w)!=0)
  x+=t*d//g
  y-=t*w//g
if x<0 or y<0 or n-x-y<0:
	print(-1)
else:
	print( x,y,n-x-y)