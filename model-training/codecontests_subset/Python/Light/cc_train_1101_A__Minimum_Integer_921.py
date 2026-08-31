x = int(input())
for i in range(x):
    a, b, c = [int(i) for i in input().split()]
    z = c
    if z < a:
        print(z)
    else:
        y = c - (b % c)
        z = b + y
        print(z)
