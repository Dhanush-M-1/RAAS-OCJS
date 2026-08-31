n = input()
a = [int(i) for i in input().split()]
b = []
c = []
for i in range(int(n)):
    if a[i] % 2 == 0: #odd
        b.append(a[i])
    else:
        c.append(a[i])
if abs(len(b) - len(c)) <= 1:
    print(0)
else:
    if (len(b) - len(c)) > 1:
        z = sorted(b)
        if len(c) == 0:
            print(sum(z[:len(z)-1]))
        else:
            print(sum(z[:(len(b) - len(c))-1]))
    if (len(c) - len(b)) > 1:
        z = sorted(c)
        if len(b) == 0:
            print(sum(z[:len(z)-1]))
        else:
            print(sum(z[:(len(c) - len(b))-1]))
            