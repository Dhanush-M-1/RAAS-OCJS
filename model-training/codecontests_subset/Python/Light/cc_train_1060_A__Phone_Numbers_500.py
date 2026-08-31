from collections import Counter
n = int(input().strip())
s = input().strip()
z = Counter(s)
if '8' not in s or n<11:
	print(0)
else:
	c=n//11
	if z['8']>=c:
		print(c)
	else:
		print(z['8'])
