n=int(input())
for i in range(n):
	a,b,d=map(int,input().split())
	if(d<a):
		print(d)
	else:
		c=b%d
		if(c==0):
			print(b+d)
		else:
			print(b+(d-c) )
