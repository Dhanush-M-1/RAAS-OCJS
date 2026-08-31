def solve(n, k, a, b, c):
	a.sort()
	b.sort()

	c.sort()

	# print(a, b, c)

	iab = min(k, len(a), len(b))
	ic = k - iab

	if ic > len(c):
		return -1

	res = 0
	for i in range(ic):
		res += c[i]
	for i in range(iab):
		res += a[i] + b[i]    	

	iab -= 1
	while ic < len(c) and iab >= 0 and c[ic] < a[iab] + b[iab]:
		res -= a[iab] + b[iab] - c[ic]
		ic += 1
		iab -= 1
		
		
	return res

current_str = input().split(" ")
n = int(current_str[0])
k = int(current_str[1])

a = []
b = []
c = []
for i in range(n):
	current_str = input().split(" ")
	t = int(current_str[0])
	aa = int(current_str[1])
	bb = int(current_str[2])
	if aa and bb:
		c.append(t)
	elif aa:
		a.append(t)
	elif bb:
		b.append(t)

print(solve(n, k, a, b, c))