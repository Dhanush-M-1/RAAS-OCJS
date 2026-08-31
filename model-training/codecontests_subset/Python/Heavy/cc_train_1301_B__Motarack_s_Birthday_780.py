for t in range(int(input())):
	n = int(input())
	a = list(map(int, input().split()))


	diff_already = 0

	baga, ih = (1 << 32), 0

	for i in range(n):
		if a[i] == -1:
			if i != 0:
				if a[i - 1] != -1:
					baga = min(baga, a[i - 1])
					ih = max(ih, a[i - 1])
			if i != n - 1:
				if a[i + 1] != -1:
					ih = max(ih, a[i + 1])
					baga = min(baga, a[i + 1])


		#
		if a[i] == -1: continue
		if i == n - 1: continue
		if a[i + 1] == -1: continue

		diff_already = max(diff_already, abs(a[i] - a[i + 1]) )

	if baga == (1 << 32):
		print("0 0")
	else:
		k = (baga + ih + 1) // 2
		m = k - baga
		print (max(diff_already, m) , k)