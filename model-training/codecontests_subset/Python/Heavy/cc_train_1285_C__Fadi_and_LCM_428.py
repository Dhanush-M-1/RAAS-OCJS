x = int(input())

if x == 1:
    print (1, 1)
    exit (0)

div = 2
factors = []
while x > 1 and div ** 2 <= x:
    p = 1
    #print (x, div)
    while x % div == 0:
        x //= div
        p *= div
    if p != 1:
        factors.append(p)
    div += 1
if x > 1:
    factors.append(x)

min_min = float('inf')
for i in range(1 << len(factors)):
    a = b = 1
    for j in range(len(factors)):
        if (i >> j) & 1:
            a *= factors[j]
        else:
            b *= factors[j]
    if max(a, b) < min_min:
        min_min = max(a, b)
        r_a, r_b = a, b

print (r_a, r_b)
