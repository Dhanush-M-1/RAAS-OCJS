a,b=input().split()
n=int(input())
for i in range(n):
	p,q=input().split()
	print(a,b)
	if p==a:
		a=q
	elif b==p:
		b=q
	if i==n-1:
		print(a,b)