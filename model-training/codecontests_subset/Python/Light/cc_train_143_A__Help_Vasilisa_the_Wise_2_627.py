from itertools import combinations, permutations
r1, r2 = (int(x) for x in input().split())
c1, c2 = (int(x) for x in input().split())
d1, d2 = (int(x) for x in input().split())
for x, y, z, w in combinations(range(1, 10), 4):
	for x, y, z, w in permutations([x, y, z, w]):
		if (x + y == r1 and z + w == r2 and x + z == c1 and
        	    y + w == c2 and x + w == d1 and y + z == d2):
			print(x, y)
			print(z, w)
			break
	else:
		continue
	break
else:
	print(-1)
