a,b=input().strip().split()[:2]
n=int(input())
print(a,b)
for x in range(n):
	c,d=input().strip().split()[:2]
	if c==a:
		print(d,b)
		a=d
	else:
		b=d
		print(a,b)