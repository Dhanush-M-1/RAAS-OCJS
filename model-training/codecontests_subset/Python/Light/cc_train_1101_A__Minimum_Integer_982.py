from math import ceil
x = int(input())
for i in range(x):
	a,b,c = map(int,input().split())
	if a > c:
		print(c)
	else:
		if ceil(b/c)>b//c:
			print(c*(ceil(b/c)))
		else:
			print(c*((b//c)+1))