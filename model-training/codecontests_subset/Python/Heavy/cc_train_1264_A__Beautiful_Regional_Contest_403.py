'''input
5
12
5 4 4 3 2 2 1 1 1 1 1 1
4
4 3 2 1
1
1000000
20
20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
32
64 64 63 58 58 58 58 58 37 37 37 37 34 34 28 28 28 28 28 28 24 24 19 17 17 17 17 16 16 16 16 11
'''
from sys import stdin,stdout
read = lambda : map(int,stdin.readline().split())
I = lambda: stdin.readline()

for _ in range(int(I())):
	n = int(I())
	arr = tuple(read())
	n1 = n//2-1
	flag1 = True
	while n1>=0 and arr[n1+1]==arr[n1]:
		n1 -= 1
	possible = True
	# 
	if n1<3:
		print('0 0 0')
	else:
		c1 = 1
		i1 = 1
		while arr[i1]==arr[i1-1] and i1<=n1:
			i1 = c1 = i1+1
		c2 = 0
		while (arr[i1]==arr[i1-1] or c2<=c1) and i1<=n1:#key logic
			i1 += 1
			c2 += 1
		b = n1-(c1+c2)+1
		if b>c1:
			print(c1,c2,b)
		else:
			print('0 0 0')
