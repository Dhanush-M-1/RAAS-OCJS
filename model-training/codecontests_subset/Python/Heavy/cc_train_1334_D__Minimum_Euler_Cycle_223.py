def genGroup(lo, n):
    if lo == n:
        return [1]
    s = []
    for i in range(lo+1, n+1):
        s.append(lo)
        s.append(i)
    return s

for tc in range(int(input())):
    n, beg, end = map(int, input().split())
    if beg == n*(n-1)+1:
        print(1)
    else:
        past = 0
        i = 1
        while past + 2*(n-i) < beg:
            past += 2*(n-i)
            i += 1
        #print(i, past)
        group = i
        s = genGroup(group, n)
        pos = beg - past - 1
        res = []
        for i in range(end-beg+1):
            res.append(s[pos])
            pos += 1
            if pos == len(s):
                pos = 0
                group += 1
                s = genGroup(group, n)
        print(*res)
