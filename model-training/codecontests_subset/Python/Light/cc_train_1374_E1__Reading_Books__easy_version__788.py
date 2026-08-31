n, k = map(int, input().split())
a = []
b = []
ab = []
for i in range(n):
	x, y, z = map(int, input().split())
	if y == 1 and z == 1:
		ab.append(x)
	elif y == 1:
		a.append(x)
	elif z == 1:
		b.append(x)
a = sorted(a)
b = sorted(b)
#ab = sorted(ab)
for i in range(min(len(a), len(b))):
	ab.append(a[i] + b[i])
ab = sorted(ab)
ans = 0
if len(ab) >= k:
	
	for i in range(k):
		ans += ab[i]
else:
	print(-1)
	exit()
print(ans)		

