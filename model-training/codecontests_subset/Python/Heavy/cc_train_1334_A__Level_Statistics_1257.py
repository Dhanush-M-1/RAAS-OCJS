if __name__ == "__main__":
	t = int(input())
	for test in range(t):
		n = int(input())
		prev_attempts = 0
		prev_clears = 0
		flag = True

		for inputs in range(n):
			attempts, clears = input().split()
			attempts, clears = int(attempts), int(clears)

			delta_a = attempts - prev_attempts
			delta_c = clears - prev_clears
			prev_attempts = attempts
			prev_clears = clears

			if delta_a <0 or delta_c<0:
				flag = False
			if delta_c > delta_a:
				flag = False

		if flag:
			print("YES")
		else:
			print("NO")