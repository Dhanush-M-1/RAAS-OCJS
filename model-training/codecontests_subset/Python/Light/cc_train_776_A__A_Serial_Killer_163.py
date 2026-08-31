c,d = input().split()
for _ in range(int(input())):
	print(c,d)
	a,b = input().split()
	if(c == a):
		c = b
	else:
		d = b
print(c,d)