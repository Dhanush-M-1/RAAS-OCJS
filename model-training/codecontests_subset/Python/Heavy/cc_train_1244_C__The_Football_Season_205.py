def gcd (a, b): 
	if (a == 0):
		ans = [b, 0, 1]
		return ans
	d = gcd (b % a, a)
	ans = [d[0], d[2] - (b // a) * d[1], d[1]]
	return ans
n, p, w, d = map(int, input().split())
g = gcd(w, d)
if p % g[0] != 0:
    print (-1)
else:
    w = w // g[0]
    d = d // g[0]
    x = g[1] * (p // g[0])
    y = g[2] * (p // g[0])
    if y >= 0:
        c = y // w
        y -= c * w
        x += c * d
    else:
        c = (abs(y) + w - 1) // w
        y += c * w
        x -= c * d
    if x < 0:
        print(-1)
    elif x + y > n:
        print(-1)
    else:
        print(x, y, n - x - y)