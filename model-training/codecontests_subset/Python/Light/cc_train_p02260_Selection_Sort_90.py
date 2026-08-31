n = int(input())
a = list(map(int, input().split()))
count = 0
for i in range(n):
	minj = min(range(i, n), key=lambda j: a[j])
	if i != minj:
		a[i], a[minj] = a[minj], a[i]
		count += 1
print(*a)
print(count)
