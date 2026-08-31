import sys
def ext(a, b):
	if(a == 0):
		return (0, 1)
	p1, q1 = ext(b%a, a)
	return (q1 - p1*(b//a), p1)

n,p,w,d = map(int, input().split())

x0, y0 = ext(w, d)
gc = x0*w + y0*d
w//= gc
d//= gc


if(p % gc):
	print('-1')
	sys.exit()

p//= gc

x0*= p
y0*= p

if(x0 < 0):
	k = (0 - x0 + d - 1)//d; 
	x0+= k*d;  
	y0-= k*w;

if(y0 < 0):
	k = (0 - y0 + w - 1)//w; 
	x0-= k*d;  
	y0+= k*w;

if(x0<0 or y0<0):
	print('-1')
	sys.exit()


if((x0 + y0) > n):
	k = (x0 + y0 - n + w - d - 1)//(w - d); 
	x0+= k*d;  
	y0-= k*w;

if(x0<0 or y0<0):
	print('-1')
	sys.exit()

#print(x0*w + y0*d)
print('%d %d %d'%(x0, y0, n - x0 - y0))