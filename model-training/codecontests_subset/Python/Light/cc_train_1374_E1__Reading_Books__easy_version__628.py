n,k = map(int,input().split())
x = list()
y = list()
z = list()
for _ in range(n):
	t,a,b = map(int,input().split())
	if a == 0 and b == 0:
		continue
	elif a == 1 and b == 0:
		x.append(t)
	elif a == 0 and b == 1:
		y.append(t)
	else:
		z.append(t)
x.sort()
y.sort()
for i in range(min(len(x),len(y))):
	z.append(x[i] + y[i])
z.sort()
if len(z) < k:
	print("-1")
else:
	res = 0;
	for i in range(0,k):
		res += z[i];
	print(res)
