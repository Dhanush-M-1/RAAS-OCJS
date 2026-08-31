n,k = map(int, input().split())
a,b,ab = [],[],[]
for _ in range(n):
	t,x,y = map(int, input().split())
	if x + y == 2:
		ab.append(t)
	elif x == 1:
		a.append(t)
	elif y == 1:
		b.append(t)
a.sort()
b.sort()
for i in range(min(len(a),len(b))):
	ab.append(a[i]+b[i])
ab.sort()
if len(ab) < k:
	print(-1)
else:
	sum = 0
	for i in range(k):
		sum += ab[i]
	print(sum)