import sys

#list(map(int, sys.stdin.readline().split()))
#map(int, sys.stdin.readline().split())


t = int(sys.stdin.readline())
for _ in range(t):
	n = int(sys.stdin.readline())
	liste = [list(map(int, sys.stdin.readline().split())) for i in range(n)]
	out = "YES"
	if liste[0][0] < liste[0][1]:
		out = "NO"
	for i in range(1, n):
		if liste[i][0] < liste[i-1][0] or liste[i][1] < liste[i-1][1] or (liste[i][1]-liste[i-1][1] > liste[i][0]-liste[i-1][0]) or liste[i][0] < liste[i][1]:
			out = "NO"
			break
	print(out)

