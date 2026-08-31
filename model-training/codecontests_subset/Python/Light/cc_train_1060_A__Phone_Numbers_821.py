from collections import Counter
n = int(input())
s = input()
if n < 11:
	print(0)
else:
	c = Counter(s)
	eight = c.get('8', 0)
	numbers = n//11
	if eight >= numbers:
		print(numbers)
	else:
		print(eight)
