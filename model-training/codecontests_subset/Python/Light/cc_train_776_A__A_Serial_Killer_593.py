f = input()

print(f)
h = f.split()

a = int(input())

for i in range(a):
    g = input()
    qq = g.split()
    if h[0] == qq[0]:
        h[0] = qq[1]
    else:
        h[1] = qq[1]
    print(' '.join(h))