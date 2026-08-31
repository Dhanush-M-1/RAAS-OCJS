n, k = map(int, input().split())
lst = list(map(int, input().split()))
mx = -1
for i in sorted(lst):
	if k % i == 0:
		mx = i
print((k + mx - 1) // mx)