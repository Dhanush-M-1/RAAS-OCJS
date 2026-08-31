n, m = map(int, input().split())
a = set()
for i in range(n):
	b = list(map(int, input().split()))
	b = b[1:]
	for i in b:
		a.add(i)
if len(a) == m:
	print("YES")
else:
	print("NO")
	
