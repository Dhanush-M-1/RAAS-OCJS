def prefixSum(array):
	if len(array) == 0:
		return []
	l = [array[0]]

	for i in array[1:]:
		l.append(i+l[-1])

	return l


n, k = map(int, input().split())

alice = []
bob = []
both = []

for i in range(n):
	t, a, b = map(int, input().split())

	if a == 1 and b == 1:
		both.append(t)
		continue

	if a == 1:
		alice.append(t)

	if b == 1:
		bob.append(t)


alice.sort()
bob.sort()
both.sort()

if len(alice)+len(both)<k or len(bob)+len(both)<k:
	print(-1)

else:
	if len(alice) == 0 or len(bob) == 0:
		s = sum(both[:k])
		print(s)

	else:
		bothP = prefixSum(both)
		aliceP = prefixSum(alice)
		bobP = prefixSum(bob)

		minTime = 10**18

		# If all k are picked from individual
		if len(alice)>=k and len(bob)>=k:
			minTime = aliceP[k-1] + bobP[k-1]

		# If all are picked from both
		if len(both) >= k:
			minTime = min(minTime, bothP[k-1])

		# If anywhere between 1 to k-1 are picked from both
		for i in range(1, k):
			# Remaining k-i books cannot be picked
			if not (k-i <= len(alice) and k-i <= len(bob)):
				continue

			# There are not i books in both
			if i>len(both):
				continue

			# Pick i common rest uncommon
			elif bothP[i-1] + aliceP[k-i-1] + bobP[k-i-1] < minTime:
				minTime = bothP[i-1] + aliceP[k-i-1] + bobP[k-i-1]

		print(minTime)
