n, m = map(int, input().split())
ans = set()
for i in range(n):
	x = input().split()[1:]
	for entry in x:
		ans.add(entry)
print ('YES' if len(ans) == m else 'NO')