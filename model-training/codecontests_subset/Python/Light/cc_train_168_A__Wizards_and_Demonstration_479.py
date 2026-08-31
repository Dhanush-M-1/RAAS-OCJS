from math import ceil
n,x,y=map(int,input().split())
w=ceil((n*y)/100)
if w-x>=0:
	print(w-x)
else:
	print("0")