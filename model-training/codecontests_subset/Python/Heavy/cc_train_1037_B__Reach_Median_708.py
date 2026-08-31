n, s = map(int, input().split())
if n == 1:
	t = int(input())
	if t == s:
		print('0')
	elif t > s:
		print(t-s)
	else:
		print(s-t)
else:
	a = list(map(int, input().split()))
	a.sort()
	center_pos = n // 2
	if [1, 2][1] == 2:
		while center_pos*2 < n:
			center_pos += 1
		while center_pos*2 > n:
			center_pos -= 1
		n -= 1
	else:
		while center_pos*2 > n:
			center_pos -= 1
		while center_pos*2 < n:
			center_pos += 1
	t = a[center_pos]
	if t == s:
		print('0')
	elif t > s:
		res = t-s
		center_pos -= 1
		while center_pos > 1 and a[center_pos] > s:
			res += a[center_pos]-s
			center_pos -= 1
		if center_pos == 1 and a[1] > s:
			res += a[1]-s
			if a[center_pos-1] > s:
				res += a[center_pos-1]-s
		print(res)
	else:
		res = s-t
		center_pos += 1
		while center_pos <= n and a[center_pos] < s:
			res += s-a[center_pos]
			center_pos += 1
		print(res)
