from sys import stdin
input = stdin.buffer.readline

n, k = map(int, input().split())
a, b, c = [], [], []
for i in range(n):
	t, x, y = map(int, input().split())
	if x & y:
		c.append(t)
	elif x:
		a.append(t)
	elif y:
		b.append(t)
a.sort(reverse=True)
b.sort(reverse=True)
c.sort(reverse=True)
ans = 0
for i in range(k):
	if a and b and c:
		if c[-1] < a[-1] + b[-1]:
			ans += c.pop()
		else:
			ans += a.pop() + b.pop()
	elif c:
		ans += c.pop()
	elif a and b:
		ans += a.pop() + b.pop()
	else:
		exit(print(-1))
print(ans)
		