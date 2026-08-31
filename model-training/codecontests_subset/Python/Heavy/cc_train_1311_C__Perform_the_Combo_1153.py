t = int(input())

for i in range(t):
	n, m = [int(x) for x in input().split(' ')]
	s = input()
	p = [int(x) for x in input().split(' ')] + [n]

	letters = {key: [0, 0] for key in list('abcdefghijklmnopqrstuvwxyz')}
	p.sort()

	for x in range(m+1):
		for j in letters:
			if letters[j][0] > 0:
				letters[j][1] += letters[j][0]

		if x == 0:
			a = 0
		else:
			a = p[x-1]

		for j in range(a, p[x]):
			letters[s[j]][0] += 1
			letters[s[j]][1] += 1

	for x in letters.values():
		print(x[1], end=" ")
	print()

