def Garden(n,k,a):
	minHrs = k
	for b in a:
		if k%b==0:
			if minHrs > (k/b):
				minHrs = int(k/b)

	return minHrs

n,k = [int(x) for x in input().split()]
a = [int(x) for x in input().split()]

print(Garden(n,k,a))