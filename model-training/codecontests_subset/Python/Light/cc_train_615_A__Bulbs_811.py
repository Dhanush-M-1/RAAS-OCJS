n, m = map(int, input().split())
l = []
for i in range(n):
	s = list(map(int, input().split()))[1:]
	l.append(s)
print("YES" if m == len(set(sum(l, []))) else "NO")