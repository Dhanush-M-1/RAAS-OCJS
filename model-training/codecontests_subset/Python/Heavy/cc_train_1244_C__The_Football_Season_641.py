import math
x=int(1)
y=int(0)
reqgcd=int(-1)
def exgcd(a,b):
	global x
	global y

	if(b==0):
		global reqgcd
		reqgcd=a
	else:
		exgcd(b,a%b)
		y1=x-((a//b)*y)
		x1=y
		y=y1
		x=x1


def func():
	n,p,w,d=input().split(" ")
	# x=1;
	# y=0;
	n=int(n)
	p=int(p)
	w=int(w)
	d=int(d)
	exgcd(w,d)
	gcd=reqgcd
	if p%gcd!=0:
		print("-1")
		return
	# print("p:%d"%(p))
	# print("gcd:%d"%(gcd))
	k=int(p)//int(gcd)
	# print(int(p)//int(gcd))
	# print("k:%d"%(k))
	x1=int(x)
	y1=int(y)
	# print("x1:%d y1:%d"%(x1,y1))
	# print((int(int(-1) * int(k * x1))+int(int(d/gcd))-1))
	# print(((int(int(-1) * int(k * x1))+int(int(d/gcd))-1) / int(d/gcd)))
	lt = math.ceil((int(int(-1) * int(k * x1)) / int(d/gcd)))
	# print("also %d",int(int(d//gcd)-int(1)))
	# print("%d"%((-1 * k * x1)))
	# print("%d"%(((d//gcd)-1)))
	# print("%d"%((-1 * k * x1)+((d//gcd)-1)))
	# print("%d"%((d//gcd)))
	# print("%d"%(k))
	# print("%d"%(y1))
	# print("endehere")
	k=int(k)
	y1=int(y1)
	# print((int(k * y1)-int(int(w/gcd)-int(1))))
	# print(((int(k * y1)-int(int(w/gcd)-int(1))) / int(w/gcd)))
	ut = math.floor((int(k * y1)) // int(w//gcd))
	# print("%d"%(k))
	# print("%d"%(y1))
	
	# # print(((k * (-1*y1))))
	# w=k*y1
	# print("w:%d"%(w))
	# print("%2d"%(((w//gcd)-1)))
	# print("%2d"%((k * y1)-((w//gcd)-1)))
	# print("%2d"%((w//gcd)))
	# print("lt:%2d ut:%2d"%(lt,ut))
	# print(ut) 
	if (d > w):
		k=int(k)
		x1=int(x1)
		y1=int(y1)
		d=int(d)
		w=int(w)
		gcd=int(gcd)
		uft = math.floor(((n - k * x1 - k * y1)) / ((d/gcd) -(w/gcd)))
		# cout<<uft
		ufft = min(uft, ut)
		if (ufft >= lt):
			xx1 = ((ufft * d) // gcd) +  k * x1
			yy1 = (-(ufft * w) // gcd) + k * y1
			print("%d %d %d"%(xx1,yy1,n-xx1-yy1))
			# print(xx1,end=' ') 
			# print(yy1,end=' ')
			# print(n-xx1-yy1)		
		else:
			print("-1")
		
		

	
	elif (d < w):
		lft = math.ceil(((-1 * (((n - k * x1 - k * y1))))) // ((w/gcd) - (d/gcd)))
		lfft = max(lft, lt)
		# print("lfft:%d ut:%d"%(lfft,ut))
		if (ut >= lfft):
			xx1 = ((ut * d) // gcd) + k * x1
			yy1 = -((ut * w) // gcd) + k * y1
			print("%d %d %d"%(xx1,yy1,n-xx1-yy1))
			# print(xx1,end=' ') 
			# print(yy1,end=' ')
			# print(n-xx1-yy1)	
		
		else:
			print("-1")
	
	else:
		if (k * x1 + k * y1 <= n and (x1 >= 0 and y1 >= 0)):
			xx1=k*x1 
			yy1=k*y1
			print("%d %d %d"%(xx1,yy1,n-xx1-yy1))
			# print(xx1,end=' ') 
			# print(yy1,end=' ')
			# print(n-xx1-yy1)
			# return
		
		else:
			print("-1")

	



func()