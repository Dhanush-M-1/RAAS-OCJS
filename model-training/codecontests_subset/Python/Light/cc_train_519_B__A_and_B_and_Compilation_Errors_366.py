n = int(input())
vals1 = list(sorted([int(x) for x in input().split()]))
vals2 = list(sorted([int(x) for x in input().split()]))
vals3 = list(sorted([int(x) for x in input().split()]))

def findDif(l1, l2):
	for i in range(len(l2)):
		if l1[i] != l2[i]:
			return l1[i]
	return l1[len(l2)]

print(findDif(vals1, vals2))
print(findDif(vals2, vals3))