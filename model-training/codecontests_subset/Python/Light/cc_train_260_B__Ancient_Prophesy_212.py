from collections import Counter

numbers = '0123456789'
days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

def check(s):
	if s[2] != '-' or s[5] != '-':
		return False
	if any(c not in numbers for (i, c) in enumerate(s) if i != 2 and i != 5):
		return False
	d = int(s[:2])
	m = int(s[3:5])
	y = int(s[6:])
	if y < 2013 or y > 2015:
		return False
	if m == 0 or m > 12:
		return False
	return d != 0 and d <= days[m - 1]

s = input()
print(Counter(s[i:i+10] for i in range(len(s) - 9) if check(s[i:i+10])).most_common(1)[0][0])
