k = int(input()); a = str(input()); y = 1; s = 1
if k == 1:
    print(a)
    exit()
a = sorted(a); b = ""
if len(a) > 2 and a[len(a) - 1] != a[len(a) - 2] and k != 1:
    print("-1")
else:
    while y < len(a):
        if a[y] == a[y - 1]:
            s += 1
        else:
            if s % k == 0:
                b += (s // k) * a[y - 1]
                s = 1
            else:
                print(k - (k + 1))
                exit()
        y += 1
    if s != 1:
        if s % k == 0:
            b += (s // k) * a[len(a) - 1]
        else:
            print(k - (k + 1))
            exit()
    print(b * k)