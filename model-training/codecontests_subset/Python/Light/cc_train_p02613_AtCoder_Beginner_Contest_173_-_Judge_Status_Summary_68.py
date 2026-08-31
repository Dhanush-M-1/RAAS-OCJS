n = int(input())
l = [input() for i in range(n)]
reslt = ["AC", "WA", "TLE", "RE"]
for j in range(4):
	print(reslt[j], "x", l.count(reslt[j]))