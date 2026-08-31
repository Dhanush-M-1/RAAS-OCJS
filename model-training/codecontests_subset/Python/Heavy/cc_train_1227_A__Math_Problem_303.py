t = int(input())
while t:
    t += -1
    n = int(input())
    al = 0
    ar = 9999999999
    c = 0
    for i in range(n):
        l, r = [int(x) for x in input().split()]
        if c == 0:
            al = max(al, l)
            ar = min(ar, r)
        if c == 0 and al > ar:
            al, ar = ar, al
            c = 1
            continue
        if c == 1:
            if al <= l <= ar or al <= r <= ar:
                continue
            else:
                if r < al:
                    al = r
                elif l > ar:
                    ar = l
    if c == 0: print(0)
    else: print(ar - al)