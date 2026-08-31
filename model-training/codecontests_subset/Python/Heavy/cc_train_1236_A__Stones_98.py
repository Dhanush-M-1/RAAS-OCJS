testes = int(input())

for t in range(testes):
    ent = input().split(" ")
    h1 = int(ent[0])
    h2 = int(ent[1])
    h3 = int(ent[2])

    t2 = h3//2

    if t2 <= h2:
        h2 -= t2
        h3 -= t2*2

    else:
        t2 = h2
        h2 = 0
        h3 -= t2*2

    t1 = h2//2
    if t1 <= h1:
        h1 -= t1
        h2 -= t1*2
    else:
        t1 = h1
        h1 = 0
        h2 -= t1*2

    op = t2 + t1

    h1 = int(ent[0])
    h2 = int(ent[1])
    h3 = int(ent[2])

    t1 = h2//2
    if t1 <= h1:
        h1 -= t1
        h2 -= t1*2
    else:
        t1 = h2
        h1 = 0
        h2 -= t1*2

    t2 = h3//2

    if t2 <= h2:
        h2 -= t2
        h3 -= t2*2

    else:
        t2 = h2
        h2 = 0
        h3 -= t2*2

    op2 = t1 + t2

    if op > op2:
        print(op*3)
    else:
        print(op2*3)
