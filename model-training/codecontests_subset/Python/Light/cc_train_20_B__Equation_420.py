import math
a,b,c = map(int,input().split(' '))

def root(a,b,c):
	d = (b**2) - (4*a*c)
	if d == 0:
		#Equal Root
		x = (-b)/(2*a)
		print(1)
		print("%.10f"%x) 
	elif d > 0:
		#real root
		x = ((-b)+math.sqrt(d))/(2*a)
		y = ((-b)-math.sqrt(d))/(2*a)
		print(2)
		if x > y:
			print("%.10f"%y)
			print("%.10f"%x)
		else:
			print("%.10f"%x)
			print("%.10f"%y)
	else:
		#imaginary root
		print('0')
#INFINITE CHECK
if (a == 0 and b == 0 and c == 0):
	print(-1)
elif a == 0 and b != 0:
	print(1)
	x = -c/b
	print('%.10f'%x)
elif a == 0 and b == 0 and c != 0:
	print(0)
else:
	root(a,b,c)

