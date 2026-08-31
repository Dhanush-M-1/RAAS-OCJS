n = int(input())
l = [input() for i in range(n)]
reslt = ["AC", "WA", "TLE", "RE"]
for j in reslt:
	print('{0} x {1}'.format(j, l.count(j)))