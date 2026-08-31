n, k = map(int, input().split())

a = list(map(int, input().split()))
cur = 0;
for i in range(n):
	if (k % a[i] == 0 and a[i] > cur):
		cur = a[i]

if (cur == 0):
	print(k+1)

else:
	print(k//cur)