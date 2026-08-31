def gcd(a, b):
	while b:
		a, b = b, a % b
	return a
t = int(input())
abcd_list = [[int(i) for i in input().split()] for _ in range(t)]

for i in range(len(abcd_list)):
    a, b, c, d = abcd_list[i]
    if b > a:
        print("No")
        continue
    if b > d:
        print("No")
        continue
    if c > b:
        print('Yes')
        continue
    g = gcd(b, d)
    max_mod_b = b - g + a % g
    if max_mod_b > c:
        print('No')
    else:
        print("Yes")



