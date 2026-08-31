n, k = map(int,input().split())
a = list(map(int,input().split()))
a.sort()
a.reverse()
for x in range(0, len(a)):
	if k % a[x] == 0:
		# print(x, a[x])
		print(int(k / a[x]))
		break