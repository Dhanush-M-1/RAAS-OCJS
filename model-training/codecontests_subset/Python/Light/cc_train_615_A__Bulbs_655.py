n, m = map(int, input().split())
s = set()
for t in range(n):
	arr = list(map(int, input().split()))
	for i in arr[1:]:
		s.add(i)
if len(s) == m:
	print("YES")
else:
	print("NO")