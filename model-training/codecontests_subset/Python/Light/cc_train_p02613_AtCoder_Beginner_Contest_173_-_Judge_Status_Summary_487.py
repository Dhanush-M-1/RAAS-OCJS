n = int(input())
s = [str(input()) for _ in range(n)]
for v in ("AC","WA","TLE","RE"):
	print("{0} x {1}".format(v,s.count(v)))
