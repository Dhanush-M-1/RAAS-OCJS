ab = list(map(int, input().split()))
hours = 0
fireless = 0
while ab[0] > 0:
	hours += ab[0]
	fireless += ab[0]
	ab[0] = (fireless // ab[1])
	fireless -= ((fireless // ab[1]) * ab[1])
print(hours)