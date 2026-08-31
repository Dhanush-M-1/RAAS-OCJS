#Python Template

from sys import stdin, stdout

def update(l, b, a):
	for i in range(len(b)):
		a[i + l - 1] += b[i]
	#print(a)

def disp(l, r, b):
	stdout.write("{0} {1}\n".format(l, r))
	stdout.write(" ".join([str(i) for i in b]))
	stdout.write("\n")

def main():
	n = int(stdin.readline())
	a = [int(i) for i in stdin.readline().split()]
	if n != 1:
		#First change: Altering the first value to be a multiple of n
		l, r = 1, 1
		b = [0]*(r-l+1)
		b[0] = n-a[0]

		update(l, b, a)
		disp(l,r,b)
		#Second change: Altering the last n-1 values to be multiples of n
		l, r = 2, n
		b = [0]*(r-l+1)
		length = n-1
		for i in range(l-1, r):
			v = a[i]%n
			v2 = length*v
			b[i-l+1] = v2
		update(l, b, a)
		disp(l,r,b)
		#Third Change: Altering all values to 0
		l, r = 1, n
		b = [0]*(r-l+1)
		for i in range(n):
			b[i] = -a[i]

		update(l, b, a)
		disp(l,r,b)
	else:
		#First change: Altering the first value to be a multiple of n
		l, r = 1, 1
		b = [-a[0]]

		update(l, b, a)
		disp(l,r,b)
		#Second change: Altering the last n-1 values to be multiples of n
		b = [0]

		update(l, b, a)
		disp(l,r,b)
		#Third Change: Altering all values to 0
		b = [0]

		update(l, b, a)
		disp(l,r,b)



main()