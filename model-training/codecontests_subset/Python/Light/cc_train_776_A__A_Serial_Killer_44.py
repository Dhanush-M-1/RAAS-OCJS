a,b=input().split()
print(a,b)
for x in range(int(input())):
	c,d=input().split()
	if a==c:
		a=d
		print(a,b)
	else:
		b=d
		print(a,b)