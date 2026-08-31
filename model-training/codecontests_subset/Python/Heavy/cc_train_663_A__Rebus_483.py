def set_numbers(S, k):
	ans = []
	for i in range(k):
		ans.append(S // k)
	for i in range(S - k*(S // k)):
		ans[i] += 1
	return ans


s = input().split()

i = s.count('+') + 1
j = s.count('-')
n = int(s[-1])

if i-j*n <= n <= i*n-j:
	print('Possible')
	S1 = max(i, j + n)
	l1 = [] if i == 0 else set_numbers(S1, i)
	S2 = S1 - n
	l2 = [] if j == 0 else set_numbers(S2, j)

	p = 0
	q = 0
	for k in range(len(s)):
		if k == 0:
			s[k] = str(l1[p])
			p += 1
		elif s[k] == '?':
			if s[k - 1] == '+':
				s[k] = str(l1[p])
				p += 1
			else:
				s[k] = str(l2[q])
				q += 1
	print(" ".join(s))
else:
	print('Impossible')