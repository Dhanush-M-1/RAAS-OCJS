def solve():
	n = int(input())
	points = []

	x = input()
	x = [int(i) for i in x.split(' ')]
	for i in x:
		points.append([i, 0])

	y = input()
	y = [int(i) for i in y.split(' ')]
	for i, v in enumerate(y):
		points[i][1] = v

	points.sort()
	ans = 0
	start = [1, 1]
	for x, y in points:
		a, b = start
		if x - y == a - b:
			if (a - b) % 2 == 0:
				ans += y - b
		else:
			ans += (x - y) // 2 - (a - b) // 2
		start = [x, y]
	print(ans)


def main():
	t = int(input())
	while t:
		solve()
		t -= 1



if __name__ == '__main__':
	main()