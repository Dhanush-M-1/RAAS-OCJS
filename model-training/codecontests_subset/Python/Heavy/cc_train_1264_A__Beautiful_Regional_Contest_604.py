t = int(input())
for q in range(t):
    n = int(input())
    inp = list(map(int, input().split()))
    i = 0
    line = []
    while i < n:
        count = 1
        while i + 1 < n and inp[i] == inp[i + 1]:
            count += 1
            i += 1
        line.append(count)
        i += 1
    l = 3
    r = n // 2
    cg = line[0]
    cs = 0
    i = 1
    while i < len(line) and cg + cs + line[i] <= n // 2 and cs <= cg:
        cs += line[i]
        i += 1
    if i < len(line) and cg + cs + line[i] <= n // 2:
        cb = line[i]
        i += 1
    else:
        cb = 0
    while i < len(line) and cg + cs + cb + line[i] <= n // 2:
        cb += line[i]
        i += 1
    if cb > cg:
        print(cg, cs, cb)
    else:
        print(0, 0, 0)
        