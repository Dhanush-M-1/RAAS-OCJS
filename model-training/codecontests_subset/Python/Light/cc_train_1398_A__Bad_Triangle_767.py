def main():
	t = int(input())
	for _ in range(t):
		n = int(input())
		a = list(map(int, input().split()))
		x, y = a[0], a[1]
		z = x + y
		ans = 0
		for i in range(2, n):
			if a[i] >= z:
				ans = i+1
				break
		if ans == 0:
			print(-1)
		else:
			print(1, 2, ans)

main()