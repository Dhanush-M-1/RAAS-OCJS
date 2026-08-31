from sys import stdin
n = int(stdin.readline())
if n == 1:
	print(1)
	exit()
x, h = [], []
for i in range(n):
	a, b = (int(t) for t in stdin.readline().split())
	x.append(a)
	h.append(b)
a = [-1] * n
b = [-1] * n
c = [-1] * n
a[0] = 1
b[0] = 0
if x[0] + h[0] < x[1]:
	c[0] = 1
else:
	c[0] = 0
for i in range(1, n):
	if x[i - 1] < x[i] - h[i]:
		a[i] = max(a[i - 1], b[i - 1]) + 1
	if x[i - 1] + h[i - 1] < x[i] - h[i]:
		a[i] = max(a[i], c[i - 1] + 1)
	b[i] = max(a[i - 1], b[i - 1], c[i - 1])
	c[i] = b[i]
	if i + 1 == n:
		c[i] += 1
	elif x[i] + h[i] < x[i + 1]:
		c[i] += 1
print(max(a[-1], b[-1], c[-1]))
