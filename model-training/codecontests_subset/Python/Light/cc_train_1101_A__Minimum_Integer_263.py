import math
q=int(input())

for i in range(q):
	l,r,d=map(int,input().split())

	s=l/d

	if d<l:
		print(d)
	elif d>=l and d<=r:

		if d*math.ceil(r//d)<=r:
			print(d*math.ceil(r//d)+d)
		else:
			print(d*math.ceil(r//d))
	else:
		print(d)