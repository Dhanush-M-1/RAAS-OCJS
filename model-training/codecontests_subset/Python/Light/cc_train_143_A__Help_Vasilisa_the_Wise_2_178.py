r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
for a in range(1,10):
	for b in range(1,10):
		if b==a:continue
		for c in range(1,10):
			if c==a or c==b:continue
			for d in range(1,10):
				if d==c or d==a or d==b:continue
				if a+b==r1 and\
				   c+d==r2 and\
				   a+d==d1 and\
				   b+c==d2 and\
				   a+c==c1 and\
				   b+d==c2:
					print(a,b)
					print(c,d)
					exit()
print(-1)
# Mon Oct 05 2020 12:46:44 GMT+0300 (Москва, стандартное время)
