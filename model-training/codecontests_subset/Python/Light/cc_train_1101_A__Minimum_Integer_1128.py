from math import ceil
for q in range(int(input())):
	a,b,c=map(int,input().split())
	j,k=ceil(a/c),b//c
	print([c*(k+1),c][j>1])