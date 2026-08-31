import sys


def prepare(n):
	global facts, inv_facts
	facts = [1, 1]
	inv_facts = [1 for i in range(n)]
	for i in range(2, n):
		facts.append((facts[i - 1] * i) % m)
	inv_facts[-1] = pow(facts[-1], m - 2, m)
	for i in range(n - 2, 0, -1):
		inv_facts[i] = (inv_facts[i + 1] * (i + 1)) % m


def inv_fact(n):
	return inv_facts[n]


def fact(n):
	return facts[n]


def c(n, k):
	if (k < 0) or (k > n):
		return 0
	return (fact(n) * ((inv_fact(k) * inv_fact(n - k)) % m)) % m


n, k = map(int, sys.stdin.readline().split())
a = []
for i in range(n):
	l, r = map(int, sys.stdin.readline().split())
	a.append((l << 1))
	a.append((r << 1) + 1)
a.sort()
s = 0
m = 998244353
prepare(300010)
ans = 0
for b in a:
	if (b & 1) == 0:
		s += 1
		ans += c(s - 1, k - 1)
		if ans >= m:
			ans -= m
	else:
		s -= 1
print(ans)