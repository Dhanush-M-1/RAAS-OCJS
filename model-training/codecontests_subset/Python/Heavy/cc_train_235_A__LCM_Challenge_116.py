def gcd(a, b):
	while b > 0:
		a %= b
		a, b = b, a
	return a


def lcm(a, b):
	return a // gcd(a, b) * b


def max_nok(n):
    if n % 2 == 1:
        return n * (n - 1) * (n - 2)
    else:
#        return (n - 1) * (n - 2) * (n - 3)
        x = lcm(n - 1,  n - 2)
        y = lcm(x, n)
        return y


N = int(input())
if N == 1:
    print(1)
elif N == 2:
    print(2)
elif N == 3:
    print(6)
elif N == 4:
    print(12)
elif N == 5:
    print(60)
#elif N % 2 == 1:
#    print(N * (N - 1) * (N - 2))
else:
    l = max(3, N - 100)
    r = N
    result = list()
    for a in range(l, r - 1):
        for b in range(a + 1, r):
            for c in range(b + 1, r + 1):
                x = lcm(a, b)
                y = lcm(x, c)
                result.append(y)
    print(int(max(result)))

