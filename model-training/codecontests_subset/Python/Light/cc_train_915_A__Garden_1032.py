nk = list(map(int, input().split()))
a = list(map(int, input().split()))
a.sort()
for i in range(nk[0] - 1, -1, -1):
	if nk[1] % a[i] == 0:
		print(nk[1] // a[i])
		break