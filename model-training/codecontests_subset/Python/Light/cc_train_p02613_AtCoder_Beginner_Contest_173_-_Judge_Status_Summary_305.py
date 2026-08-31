from collections import Counter

C = Counter(input() for _ in range(int(input())))

for w in 'AC WA TLE RE'.split():
	print(w, 'x', C[w])
