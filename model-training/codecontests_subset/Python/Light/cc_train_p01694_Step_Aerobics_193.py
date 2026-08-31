def solve(n):
	ops = input().split()
	states = [0 for i in range(n + 1)]
	ans = 0
	for i in range(n):
		if ops[i] == "lu": states[i + 1] = states[i] + 1
		elif ops[i] == "ru": states[i + 1] = states[i] + 2
		elif ops[i] == "ld": states[i + 1] = states[i] - 1
		else: states[i + 1] = states[i] - 2
		if i >= 1 and (states[i - 1],states[i + 1]) in [(0,3),(3,0)]:
			ans += 1
	print(ans)

while True:
	n = int(input())
	if n == 0: break
	solve(n)
