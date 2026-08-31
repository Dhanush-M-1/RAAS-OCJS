r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())


def ok(a, b, c, d):
	if a <= 0 or b <= 0 or c <= 0 or d <= 0:
		return 0
	if a >= 10 or b >= 10 or c >= 10 or d >= 10:
		return 0
	if a == b or a == c or a == d or b == c or b == d or c == d:
		return 0
	if a + b == r1 and c + d == r2 and a + c == c1 and b + d == c2 and a + d == d1 and b + c == d2:
		return 1
	return 0


for i in range(1, 10):
	a = i
	b = r1 - a
	c = c1 - a
	d = d1 - a
	if ok(a, b, c, d):
		print(str(a) + " " + str(b) )
		print(str(c) + " " + str(d) )
		exit(0)

print(-1)

 	  	 		   		 	 			   	 			 		