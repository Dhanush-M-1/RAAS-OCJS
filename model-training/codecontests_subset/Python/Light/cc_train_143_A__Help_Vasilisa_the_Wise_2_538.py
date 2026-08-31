r1, r2 = list(map(int, input().split()))
c1, c2 = list(map(int, input().split()))
d1, d2 = list(map(int, input().split()))

a = (c1-d2+r1)/2
b = r1-a
c = c1-a
d = d1-a
if a+c==c1 and a+b==r1 and a+d==d1 and b+d==c2 and b+c==d2 and c+d==r2 and\
	a in range(1,10) and b in range(1,10) and c in range(1,10) and d in range(1,10) and\
	a!=b and a!=c and a!=d and b!=c and b!=d and c!=d:
	print(int(a),int(b))
	print(int(c),int(d))
else:
	print(-1)