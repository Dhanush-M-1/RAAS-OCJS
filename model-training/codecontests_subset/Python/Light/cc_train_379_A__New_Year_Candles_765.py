a, b = [int(i) for i in input().split()]
g = a
p = 0
l = 0
while True:
    l += g
    p += g
    g = int(p / b)
    p -= b * g
    if p < b and not g:
        print(l)
        exit(0)