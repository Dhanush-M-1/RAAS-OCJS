t = int(input())
for tt in range(0, t):
    a, b, c = [int(x) for x in input().split()]
    a1 = a
    b1 = b
    c1 = c
    resa = 0
    resb = 0
    #a
    while a-1 >= 0 and b-2 >= 0:
        a = a - 1
        b = b - 2
        resa += 3
    while b-1 >= 0 and c-2 >= 0:
        b = b - 1
        c = c - 2
        resa += 3
    #b
    while b1-1 >= 0 and c1-2 >= 0:
        b1 = b1 - 1
        c1 = c1 - 2
        resb += 3
    while a1 - 1 >= 0 and b1 - 2 >= 0:
        a1 = a1 - 1
        b1 = b1 - 2
        resb += 3
    print(max((resa, resb)))