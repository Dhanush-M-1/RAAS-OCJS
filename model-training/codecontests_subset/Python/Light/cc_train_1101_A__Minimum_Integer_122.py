q=int(input())
while(q>0):
	l,r,d=map(int ,input().split())
	i=0
	if (d<l): print(d)
	elif(d>r):print(d)
	else:print(d*((r//d)+1))
	q-=1