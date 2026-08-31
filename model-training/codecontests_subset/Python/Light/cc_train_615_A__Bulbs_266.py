n, m = list(map(int, input().split()))
s = set()
for i in range(n):
	a = map(int, input().split())
	t = 0
	for num in a:
		if t == 0:
			t += 1
		else:
			s.add(num)
if len(s) == m:
	print("YES")
else:
	print("NO")
