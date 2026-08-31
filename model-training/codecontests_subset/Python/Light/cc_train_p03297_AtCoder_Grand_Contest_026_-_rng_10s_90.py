def gcd(a, b):
	while b:
		a, b = b, a % b
	return a


T = int(input())
a = []
for i in range(T):
    a.append(list(map(int, input().split())))
for r in a:
    s, b, c, d = r[0], r[1], r[2], r[3]
    mod_list = []
    if (s < b) or (b>d):
        print('No')
        continue
    if (c>b):
        print('Yes')
        continue

    g = gcd(b,d)

    if b- g + s%g > c:
        print('No')
    else:
        print('Yes')