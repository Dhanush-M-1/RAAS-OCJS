t = int(input())
for tt in range(t):
    n = int(input())
    if n > 0:
        sp, sc = input().split()
        sp = int(sp)
        sc = int(sc)
        good = True
        if sc > sp:
            good = False
        for i in range(1, n):
            p, c = input().split()
            p = int(p)
            c = int(c)
            if p < c or p < sp or c < sc or (c - sc) > (p - sp):
                good = False
            else:
                sp = p
                sc = c
        if good:
            print("YES")
        else:
            print("NO")
    else:
        print("YES")