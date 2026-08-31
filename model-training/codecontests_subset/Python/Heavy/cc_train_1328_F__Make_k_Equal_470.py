def readInts():
	return [int(x) for x in input().split()]


def minStepsForEqual(xs, k):
	poss = set()

	for x in xs:
		while x > 0:
			poss.add(x)
			x //= 2

	result = 10 ** 9

	for pos in poss:
		# print("For candidate = ", pos)
		cnt = []
		for x in xs:
			debug_x = x
			steps = 0
			while x > pos:
				x //= 2
				steps += 1
			if x == pos:
				# print("  ", debug_x, " needs ", steps, " steps")
				cnt.append(steps)
		if len(cnt) >= k:
			# print("  Count more than ", k, "!")
			cnt.sort()
			result = min(result, sum(cnt[:k]))
			# print("  Result = ", result)

	return result



if __name__ == "__main__":
	[N, k] = readInts()
	xs = readInts()
	result = minStepsForEqual(xs, k)
	print(str(result))
