
# c a _ c
T = int(input())

MAX = 3*(10**5) + 10

for t in range(1, T + 1):
	# print('Case #' + str(t) + ': ', end = '')
	n = int(input())
	p = list(map(int, input().split()))
	a = []
	count = 1
	total = 0
	for i in range(1, len(p)):
		if p[i] == p[i - 1]:
			count += 1
		else:
			total += count
			# print(total)
			if total <= n//2:
				a.append(count)
				count = 1
			else:
				break
	# print(a)
	if not a:
		print(0, 0, 0)
		continue
	g = a[0]
	s = 0
	b = 0
	for i in a[1:]:
		if s <= g:
			s += i
		else:
			b += i


	if s > g and b > g:
		assert(g + s + b <= n//2)
		assert(g > 0 and s > 0 and b > 0)

		print(g, s, b)
	else:
		print(0, 0, 0)