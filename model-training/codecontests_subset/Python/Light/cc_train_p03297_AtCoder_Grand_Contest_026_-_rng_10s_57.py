from fractions import gcd

T, *L = map(int, open(0).read().split())

for a, b, c, d in zip(*[iter(L)] * 4):
    if a < b or d < b:
        flag = False
    elif c >= b - 1:
        flag =  True
    else:
        g = gcd(b, d)
        flag = (b + a % g - g) <= c

    if flag:
        print("Yes")
    else:
        print("No")
