a,b = [int(x) for x in input().split()]

ans = 0
melted = 0

s = a
while(a >= b):
	s += (a//b)
	r = a%b
	a //= b
	a += r

print(s)