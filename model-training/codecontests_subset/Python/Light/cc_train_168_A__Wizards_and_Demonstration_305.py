from math import ceil
n,x,y=map(int,input().split())
rew=y*n/100
if x<ceil(rew):
	print(ceil(rew)-x)
else:
	print(0)