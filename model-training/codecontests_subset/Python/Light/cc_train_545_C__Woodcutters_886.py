import sys
def solve():
	n = int(input())
	points = []
	for _ in range(n):
		x,h = map(int, input().split())
		points.append((x,h))

	lastPt = -sys.maxsize
	ans = 1
	for i in range(n-1):
		pt = points[i]
		if pt[0]-pt[1] > lastPt:
			lastPt = pt[0]
			ans += 1
			continue
		npt = points[i+1]
		if pt[0]+pt[1] < npt[0]:
			lastPt = pt[0]+pt[1]
			ans += 1
		else:
			lastPt = pt[0]
	return ans

print(solve())