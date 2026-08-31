k = int(input().strip())

for _ in range(k):
    n = int(input().strip())
    pp = pc = None
    no = False
    for _ in range(n):
        p, c = input().strip().split(" ")
        p, c = int(p), int(c)
        if no:
            continue
        if p < c:
            no = True
        dp = p
        dc = c
        if pp is not None:
            dp -= pp
            dc -= pc
        if dp < 0 or dc < 0 or dc > dp:
            no = True
        pp, pc = p, c
    if no:
        print("NO")
    else:
        print("YES")
