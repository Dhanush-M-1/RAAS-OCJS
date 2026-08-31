r1 , r2 = map(int, input().split())
c1 , c2 = map(int, input().split())
d1 , d2 = map(int, input().split())

flag = False

aa = 0
bb = 0
xx = 0
yy = 0

for a in range(1,10):
	for b in range(1,10):
		for x in range(1, 10):
			for y in range(1, 10):
				if a+b == r1 and x+y == r2 and a+x == c1 and b+y == c2 and a+y == d1 and b+x == d2:
					aa = a
					bb = b
					xx = x
					yy = y
					flag = True
					break

if flag:
	u = [aa, bb, xx, yy]
	if u.count(aa) == u.count(bb) == u.count(xx) == u.count(yy) == 1:
		print(aa, bb)
		print(xx, yy)
	else:
		print(-1)
else:
	print(-1)
