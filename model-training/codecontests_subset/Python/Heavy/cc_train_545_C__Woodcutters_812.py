from sys import stdin

N = int(stdin.readline())

X = []
H = []

# trees = {}
# gaps = []

for n in range(N):
	line = stdin.readline().strip().split()
	X.append(int(line[0]))
	H.append(int(line[1]))

	# trees[int(line[0])] = int(line[1])

# gaps = sorted([(X[i], X[i + 1]) for i in range(len(X) - 1)], key=lambda g: g[0])
# print(gaps)

# print(X, H)
# print(trees)

# trees[X[0]] = 0
# trees[X[-1]] = 0
H[0] = 0
H[-1] = 0

# print(trees)

# count = 2
# for g in gaps:
# 	l, r = g
# 	s = r - l
#
# 	# print(g, trees[l], trees[r])
#
# 	tl = trees[l]
# 	tr = trees[r]
#
# 	if tl == 0 and tr == 0:
# 		continue
#
# 	if tl > 0 and tr == 0:
# 		if tl < s:
# 			trees[l] = 0
# 			# count += 1
# 	elif tr > 0 and tl == 0:
# 		if tr < s:
# 			trees[r] = 0
# 			# count += 1
# 	else:
# 		if tl + tr < s:
# 			trees[l] = 0
# 			trees[r] = 0
# 		elif tl >= tr:
# 			if trees[l] < s:
# 				trees[l] = 0
# 				# count += 1
# 			elif tr < s:
# 				trees[r] = 0
# 				# count += 1
# 		else:
# 			if tr < s:
# 				trees[r] = 0
# 				# count += 1
# 			elif tl < s:
# 				trees[l] = 0
# 				# count += 1

for i in range(1, len(X) - 1):
	if H[i] < X[i] - X[i - 1]:
		H[i] = 0
	elif H[i] < X[i + 1] - X[i]:
		X[i] += H[i]
		H[i] = 0

print(sum(k == 0 for k in H))
