t = int(input())
for _ in range(t):
	n = int(input())
	a = list(map(int, input().split()))

	if a[-1] >= a[0] + a[1]:
		print(f'1 2 {len(a)}')
	else:
		print('-1')
