x , y = map(int,input().split(" "))
q = 0
t = x
i = 0
while t != 0:
	i += t
	x = t
	t = (x + q) // y
	q = (x + q) % y
print(i)