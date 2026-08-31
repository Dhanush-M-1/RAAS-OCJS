t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    s = input()
    x = map(int, input().split())
    
    l = []

    r = []
    res = []
    for i in range(26):
        r.append(0)
        res.append(0)

    l.append(r)

    for c in s:
        copy = l[-1].copy()
        copy[ord(c) - ord('a')] += 1
        l.append(copy)

    for v in x:
        for i in range(26):
            res[i] += l[v][i]

    for i in range(26):
        res[i] += l[-1][i]
    
    for i in range(26):
        print(res[i], end = ' ')