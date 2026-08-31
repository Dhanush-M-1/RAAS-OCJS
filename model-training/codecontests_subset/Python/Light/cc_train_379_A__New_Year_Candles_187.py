def main():
	s = input()
	a, b =map(int, s.split())
	n = 0
	y = 0
	while True:
		n += a
		t = a + y
		a = t // b
		y = t % b
		if a == 0:
			break
	print(n)
main()