n=int(input())
s=[input() for _ in range(n)]
for t in ["AC","WA","TLE","RE"]:
	print(t, "x", s.count(t))