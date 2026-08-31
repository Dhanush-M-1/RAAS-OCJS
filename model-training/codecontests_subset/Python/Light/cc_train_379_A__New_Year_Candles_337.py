a,b = map(int,input().split())
s = a
r = 0
while a >= b:
	r = r + a%b
	s = s + a//b
	a = a//b
	if r >= b:
		a = a + b
		r = r - b
	# print(s,r,a)
print(s+(r+a)//b)
