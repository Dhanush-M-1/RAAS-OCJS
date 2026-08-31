def solve():
	import sys
	nk = sys.stdin.readline().split()
	n = int(nk[0])
	k = int(nk[1])

	A = []
	B = []
	both = []

	for i in range(n):
		t,a,b = list(map(int,sys.stdin.readline().split()))

		if (a == 1 and b == 0):
			A.append(t)

		if (a==0 and b == 1):
			B.append(t)

		if (a== 1 and b == 1):
			both.append(t)

	A = sorted(A)
	B = sorted(B)
	both = sorted(both)

	pA = [0 for _ in range(len(A))]
	pB = [0 for _ in range(len(B))]
	p_both = [0 for _ in range(len(both))]

	if (len(pA) > 0):
		pA[0] = A[0]
	if (len(pB) > 0):
		pB[0] = B[0]
	if (len(p_both) > 0):
		p_both[0] = both[0]

	for i in range(1,len(A)):
		pA[i] = pA[i-1] + A[i]
	for i in range(1,len(B)):
		pB[i] = pB[i-1] + B[i]
	for i in range(1,len(both)):
		p_both[i] = p_both[i-1] + both[i]


	result = 10**10
	for i in range(min(len(both)+1,k+1)):
		num = k-i
		if (num > len(A) or num > len(B)):
			continue

		s = 0
		if (i > 0):
			s+=p_both[i-1]
		if (num > 0):
			s+=pA[num-1] + pB[num-1]

		result = min(result,s)

	if (result == 10**10):
		print(-1)
	else:
		print(result)

solve()


