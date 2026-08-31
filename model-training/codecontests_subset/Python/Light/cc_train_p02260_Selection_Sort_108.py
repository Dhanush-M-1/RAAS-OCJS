n = int(input())
a = list(map(int, input().split()))

icnt = 0
for i in range(0, len(a)):
	imin = i
	for j in range(i + 1, len(a)):
		if a[j] < a[imin]:
			imin = j
	if imin != i:
		a[i], a[imin] = a[imin], a[i]
		icnt = icnt + 1

print(' '.join([str(n) for n in a]))
print(icnt)

