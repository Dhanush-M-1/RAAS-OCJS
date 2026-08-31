n, m = map(int, input().split())
w = [0]*m
for i in range(n):
	a = list(map(int, input().split()))
	for j in range(1, len(a)):
		w[a[j]-1] = 1
if w.count(0) == 0:
	print("YES")
else:
	print("NO")
