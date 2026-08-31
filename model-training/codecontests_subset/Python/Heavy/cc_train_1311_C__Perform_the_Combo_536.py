def solve(n, m, s, p):
	s = list(s)
	tmp = [1]*n
	p.sort(key=lambda x: -x)
	p = [el-1 for el in p]

	adder = 2
	for el in p:
		tmp[el] = adder
		adder += 1
	#print(tmp)

	current = tmp[-1]
	for i in range(n-1, -1, -1):
		current = max(current, tmp[i])
		tmp[i] 	= current
	#print(tmp)

	alphabets = "abcdefghijklmnopqrstuvwxyz"
	result = [0 for el in alphabets]
	for i in range(n):
		result[ord(s[i])-97] += tmp[i]
	return " ".join(map(str, result))


t = int(input())
for _ in range(t):
	n, m = map(int, input().split())
	s = input()
	p = list(map(int, input().split()))
	result = solve(n, m, s, p)
	print(result)