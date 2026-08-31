
r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

for i in range(1,10):
	for j in range(1,10):
		if i == j:
			continue
		for k in range(1,10):
			if i == k or j == k:
				continue
			for l in range(1,10):
				if i == l or j == l or k == l:
					continue
				if i + j == c1 and k + l == c2 and i + k == r1 and j + l == r2 and i + l == d1 and j + k == d2:
					print(i, k)
					print(j, l)
					exit()
print(-1)