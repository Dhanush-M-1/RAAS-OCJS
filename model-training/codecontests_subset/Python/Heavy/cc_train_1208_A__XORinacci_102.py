def _10to2(n):
    a = []
    while n > 0:
        a.append(n % 2)
        n = n // 2
    a.reverse()
    return a
def _2to10(a):
    n = 0
    a.reverse()
    for i in range(len(a)):
        n += 2 ** i * a[i]
    return n
for i in range(int(input())):
    a, b, n = (int(x) for x in input().split())
    if n == 0:
        print(a)
        continue
    if n == 1:
        print(b)
        continue
    bin_a = _10to2(a)
    bin_b = _10to2(b)
    while len(bin_a) < len(bin_b):
        bin_a.insert(0, 0)
    while len(bin_b) < len(bin_a):
        bin_b.insert(0, 0)
    c = []
    for i in range(len(bin_a)):
        if bin_a[i] == bin_b[i] == 0:
            c.append(0)
        elif bin_a[i] == 0 and bin_b[i] == 1:
            if n % 3 == 0:
                c.append(0)
            else:
                c.append(1)
        elif bin_a[i] == 1 and bin_b[i] == 0:
            if n % 3 == 1:
                c.append(0)
            else:
                c.append(1)
        else:
            if bin_a[i] == 1 and bin_b[i] == 1:
                if n % 3 == 2:
                    c.append(0)
                else:
                    c.append(1)
    print(_2to10(c))
