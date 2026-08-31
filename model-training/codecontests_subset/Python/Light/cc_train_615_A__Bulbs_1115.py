n, m = map(int, input().split())
s = set()
for i in range(n):
	s |= set(input().split()[1:])
print("YES" if len(s) == m else "NO")
