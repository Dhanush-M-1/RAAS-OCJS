def _1 () :
	N = [int (z) for z in input().split()]
	n = N[0]
	m = N[1]
	sp = [0 for i in range (m)]
	for i in range (n) :
		s = [int(z) for z in input().split()]
		for j in range (1,s[0] + 1):
			sp [s[j] - 1] = 1
	if not 0 in sp :
		print ('YES')
	else :
		print ('NO')

_1()