import itertools

x = int(input())
x0 = x
i = 2

d = 2
last_pr = 1

divs = []
while d * d <= x:
    if x % d == 0:
        x = x // d
        last_pr *= d
    else:
        if last_pr != 1:
            divs.append(last_pr)
        last_pr = 1
        d += 1

if d == x and last_pr * x != 1:
    divs.append(last_pr* x)
else:
    if last_pr != 1:
        divs.append(last_pr)
    if x != 1:
        divs.append(x)

m = x0
ma = 1
mb = x0

for i in range(len(divs) + 1):
    combs = itertools.combinations(divs, i)
    for comb in combs:
        a = 1
        b = 1
        for d in divs:
            if d in comb:
                a *= d
            else:
                b *= d
        if max(a, b) < m:
            m = max(a, b)
            ma = a
            mb = b

print(ma, mb)
