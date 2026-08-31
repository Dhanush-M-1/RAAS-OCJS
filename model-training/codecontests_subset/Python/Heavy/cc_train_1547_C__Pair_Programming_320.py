t = int(input())

for ii in range(t):
	input()
	k, n, m = map(int, input().split())
	an_s = list(map(int, input().split()))
	bm_s = list(map(int, input().split()))

	seq = []

	total = n+m
	ap = 0
	bp = 0

	ac = False
	bc = False

	if an_s[0] > k and bm_s[0] > k:
		print(-1)
		continue

	for i in range(total):

		if ac and bc:
			break
		elif ac:
			small= bm_s[bp]
			bp += 1

		elif bc:
			small = an_s[ap]
			ap += 1

		else:
			small = min(an_s[ap], bm_s[bp])
			if small == an_s[ap]:
				ap += 1
			else:
				bp += 1

		seq.append(small)

		if ap == n:
			ac = True
		if bp == m:
			bc = True


	correct = True
	for i in seq:
		if i == 0:
			k+=1

		if i>k:
			correct = False

	if correct:
		print(*seq)

	else:
		print(-1)