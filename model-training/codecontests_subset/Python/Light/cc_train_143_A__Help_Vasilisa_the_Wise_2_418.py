r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

res = []
for a in range(1,10,1):
	b = r1-a
	c = c1-a
	d = r2-c

	if a<=9 and a>=1 and b<=9 and b>=1 and c<=9 and c>=1 and d<=9 and d>=1:
		if a+b == r1 and a+c == c1 and a+d == d1 and c+d == r2 and d+b == c2 and b+c == d2:
			if len(set([a,b,c,d])) == 4:
				print(str(a)+" "+str(b))
				print(str(c)+" "+str(d))
				exit()

print(-1)
	