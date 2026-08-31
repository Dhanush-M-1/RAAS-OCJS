n = int(input())
s = input()
def solve(n, s):
	c = s.count('8')
	while c:
		if c + 10*c <= n: return c
		c -= 1
	return c

print(solve(n,s))