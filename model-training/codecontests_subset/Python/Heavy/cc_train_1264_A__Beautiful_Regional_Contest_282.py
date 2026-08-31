tests = int(input())


def compact(a):
	b = []
	count = 1
	prev = a[0]
	for i in range(1, len(a)):
		if a[i] == prev:
			count += 1
		else:
			b.append((prev, count))
			prev = a[i]
			count = 1
	if count > 0:
		b.append((prev, count))
	return b

for test in range(tests):
	n = int(input())
	p = list(map(int, input().split(' ')))
	groups = compact(p)

	limit = n // 2
	g = s = b = 0
	for i in range(len(groups)):
		problems, count = groups[i]
		if g == 0:
			g += count
		elif s <= g: 
			s += count
		else:
			if g + s + b + count <= limit:
				b += count
			else:
				break
	if (g and s and b) and (g + s + b <= limit) and (g < s and g < b):
		print('%d %d %d' % (g, s, b))
	else:
		print('0 0 0')

	# print(n, p, b)
	# print(g, s, b)