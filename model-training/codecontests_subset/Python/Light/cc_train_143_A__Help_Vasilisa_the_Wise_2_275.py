"""

a b
c d

a+b=r1
c+d=r2
a+c=c1
b+d=c2
a+d=d1
b+c=d2


a2+c+b= r1+c1
2a+d2=r1+c1
a=(r1+c1-d2)//2
b=r1-a
c=d2-b
d=r2-c

"""

r1, r2 = map(int, input().strip().split())
c1, c2 = map(int, input().strip().split())
d1, d2 = map(int, input().strip().split())

a=(r1+c1-d2)//2
b=r1-a
c=d2-b
d=r2-c

if len(set([a, b, c, d])) != 4:
	print(-1)
elif min(a, b, c, d)<1 or max(a, b, c, d)>9:
	print(-1)
else:

	if [a+b==r1,
	c+d==r2,
	a+c==c1,
	b+d==c2,
	a+d==d1,
	b+c==d2].count(True) == 6:

		print(a, b)
		print(c, d)
	else:
		print(-1)