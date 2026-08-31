def gcd(a,b):
	while b:
		a,b=b,a%b
	return a

t=int(input())
for i in range(t):
	a,b,c,d=map(int,input().split())
	if a<b or b>d:
		print("No")
	elif b<=c:
		print("Yes")
	else:
		g=gcd(b,d)
		if (g-a%g)>=b-c:
			print("Yes")
		else:
			print("No")
